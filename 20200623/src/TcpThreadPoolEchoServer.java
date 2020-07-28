import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpThreadPoolEchoServer {
    private ServerSocket serverSocket = null;

    public TcpThreadPoolEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");

        // 先创建一个线程池实例
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            // 针对这个连接, 单独创建一个线程负责处理.
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            });
        }
    }

    public void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线!\n", clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            while (true) {
                // 1. 读取请求并解析
                String request = bufferedReader.readLine();
                // 2. 根据请求计算响应
                String response = process(request);
                // 3. 把响应写回到客户端
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();

                System.out.printf("[%s:%d] req: %s; resp: %s\n", clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request, response);
            }
        } catch (IOException e) {
            // e.printStackTrace();
            System.out.printf("[%s:%d] 客户端下线!\n", clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadPoolEchoServer server = new TcpThreadPoolEchoServer(9090);
        server.start();
    }
}