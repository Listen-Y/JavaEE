import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class TcpEchoClient {
    // 1. 启动客户端(一定不要绑定端口号) 和服务器建立连接
    // 2. 进入主循环
    //  a) 读取用户输入内容
    //  b) 构造一个请求发送给服务器
    //  c) 读取服务器的响应数据
    //  d) 把响应数据显示到界面上.
    private Socket socket = null;

    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        // 此处的实例化 Socket 过程, 就是在建立 TCP 连接
        socket = new Socket(serverIp, serverPort);
    }

    public void start() {
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            while (true) {
                // 1. 读取用户输入内容
                System.out.print("->");
                String request = scanner.nextLine();
                if ("exit".equals(request)) {
                    break;
                }
                // 2. 构造请求并发送. 此处 + \n 为了和服务器中的 readLine 相对应.
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();
                // 3. 读取响应数据.
                String response = bufferedReader.readLine();
                // 4. 把响应数据显示到界面上.
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}