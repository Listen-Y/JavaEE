import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPCilent {

    //需要指定访问服务器的目的ip和端口
    private String ip = null;
    private int port;
    private DatagramSocket socket = null;

    public UDPCilent(String ip, int port) throws SocketException {
        this.ip = ip;
        this.port = port;
        this.socket = new DatagramSocket();
    }

    public void start() throws IOException {
        System.out.println("客户端开启");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //或得数据
            System.out.print("输入数据->");
            String sentString = scanner.nextLine();
            if ("exit".equals(sentString)) {
                break;
            }
            //发送请求
            DatagramPacket sentPacket = new DatagramPacket(sentString.getBytes(), sentString.getBytes().length, InetAddress.getByName(this.ip), this.port);
            this.socket.send(sentPacket);
            //接收响应
            DatagramPacket getPAcket = new DatagramPacket(new byte[1024], 1024);
            this.socket.receive(getPAcket);
            String getString = new String(getPAcket.getData(), 0, getPAcket.getData().length).trim();
            //显示响应
            System.out.println(getString);
        }
    }

    public static void main(String[] args) {
        try {
            UDPCilent cilent = new UDPCilent("127.0.0.1", 9090);
            try {
                cilent.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
