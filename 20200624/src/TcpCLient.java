import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpCLient {
    //启动客户端使用socket与服务器进行连接
    //用户输入
    //发送请求
    //读取响应
    //显示响应
    private Socket socket = null;

    public TcpCLient(String ip, int port) throws IOException {
        this.socket = new Socket(ip, port);
    }

    public void start() {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);

        try (BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()))) {

            while (true) {
                System.out.print("输入请求数据:>");
                String put = scanner.nextLine();
                if ("exit".equals(put)) {
                    break;
                }
                bufferedWriter.write(put + "\n");
                bufferedWriter.flush();
                String get = bufferedReader.readLine();
                System.out.println(get);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            TcpCLient tcpCLient = new TcpCLient("127.0.0.1", 9090);
            tcpCLient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
