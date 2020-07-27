import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

    private DatagramSocket socket = null;

    public UDPServer(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //接收请求
            DatagramPacket getPocket = new DatagramPacket(new byte[1024], 1024);
            this.socket.receive(getPocket);
            String getString = new String(getPocket.getData(), 0,  getPocket.getLength()).trim();
            //处理请求
            String sentSreing = process(getString);
            //返回响应
            DatagramPacket sentPacket = new DatagramPacket(sentSreing.getBytes(), sentSreing.getBytes().length, getPocket.getSocketAddress());
            this.socket.send(sentPacket);

            //显示报文
            System.out.println(getPocket.getAddress().toString() + "  " + getPocket.getPort() + "  " + " repuest: " + getString
             + "respond: " + sentSreing);
        }
    }

    public String process(String getString) {

        return getString.toUpperCase();
    }

    public static void main(String[] args) throws IOException {
        try {
            UDPServer server = new UDPServer(9090);
            try {
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
