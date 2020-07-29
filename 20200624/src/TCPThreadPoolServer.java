import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPThreadPoolServer {
    //去内核找连接
    //处理这个连接对象
    //获得socket的输入流
    //处理输入流请求
    //将响应写回到socket输出流
    private ServerSocket serverSocket = null;

    //构造函数需要给服务器绑定一个端口

    public TCPThreadPoolServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        //用一个线程池去解决多个多连接问题
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    processSocket(socket);
                }

                private void processSocket(Socket socket) {
                    System.out.printf("[%s : %d] 已上线\n", socket.getInetAddress().toString(), socket.getPort());

                    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                         BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){

                        while (true) {
                            String get = bufferedReader.readLine();
                            String put = process(get);
                            bufferedWriter.write(put + "\n");
                            bufferedWriter.flush();

                            System.out.printf("[%s:%d] req: %s; resp: %s\n", socket.getInetAddress().toString(),
                                    socket.getPort(), get, put);
                        }

                    } catch (Exception e) {
                        System.out.printf("[%s : %d] 已下线\n", socket.getInetAddress().toString(), socket.getPort());
                    }
                }

                private String process(String get) {
                    return get.toUpperCase();
                }
            });
            
        }
    }

    public static void main(String[] args) {
        try {
            TCPThreadPoolServer tcpThreadPoolServer = new TCPThreadPoolServer(9090);
            tcpThreadPoolServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
