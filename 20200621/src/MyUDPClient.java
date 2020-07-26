
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

//客户端程序
public class MyUDPClient {
    //核心操作有俩步
    //启动客户端的时候需要指定连接那台服务器
    //执行任务主要流程分4步
    // 1. 从用户这里读取输入的数据.
    // 2. 构造请求发送给服务器
    // 3. 从服务器读取响应
    // 4. 把响应写回给客户端.

    //需要客户端知道要发往哪台服务器的ip 和端口 还需要一个udp的连接对象
    private String severIP = null;
    private int severPort = 0;
    private DatagramSocket socket = null;

    //需要在启动客户端的时候来指定需要连接哪个服务器
    public MyUDPClient(String severIP, int severPort) throws SocketException {
        this.severIP = severIP;
        this.severPort = severPort;
        //客户端在创建socket的时候不需要绑定端口号 但是服务器必须绑定端口号
        //因为服务器绑定了端口号 客户端才能找到去访问它
        //客户端不绑定是为了可以在一台主机上启动多个客户端
        this.socket = new DatagramSocket();
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //读取用户输入的消息
            System.out.print("输入字符串->");
            String request = scanner.nextLine();
            if ("exit".equals(request)) {
                break;
            }
            //发送请求
            //注意ip和port要分开写并且前后位置要注意
            DatagramPacket requstPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(this.severIP), this.severPort);
            socket.send(requstPacket);
            //接收服务器的响应
            DatagramPacket respondPacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(respondPacket);
            String respond = new String(respondPacket.getData(), 0, respondPacket.getLength()).trim();
            //显示响应
            System.out.println(respond);
        }
    }

    public static void main(String[] args) {
        try {
            //此时我们用于自己主机实验 127.0.0.1是一个特殊的ip(环回ip) 自己访问自己
            //如果服务器和客户端在同一台主机上旧使用环回ip 如果不在同一台主机上就必须填写服务器的ip
            //端口号必须与服务器的端口号一致
            MyUDPClient client = new MyUDPClient("127.0.0.1", 9090);
            try {
                client.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
