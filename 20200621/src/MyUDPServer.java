import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

//服务器程序
public class MyUDPServer {
    // 对于一个服务器程序来说, 核心流程也是要分成两步.
    // 1. 进行初始化操作 (实例化 Socket 对象)
    // 2. 进入主循环, 接受并处理请求. (主循环就是一个 "死循环")
    //   a) 读取数据并解析
    //   b) 根据请求计算响应
    //   c) 把响应结果写回到客户端.

    //需要一个udp的连接
    private DatagramSocket socket = null;
    //map去存储我们的汉译英数据
    private Map<String, String> map = new HashMap<>();

    //在构造函数里初始化操作实现连接 并指定端口号
    public MyUDPServer(int port) throws SocketException {
        //添加数据
        initDates();
        //服务器new socket对象的时候需要和一个ip地址和端口号绑定起来
        //如果没有写ip 则默认时0.0.0.0 (一个特殊的ip会关联到这个主机的国有网卡的ip)
        //socket对象本省就是一个文件
        socket = new DatagramSocket(port);
    }

    private void initDates() {
        map.put("猫", "cat");
        map.put("猪", "pig");
        map.put("狗", "dog");
        map.put("人", "people");
        map.put("笔", "pen");
        map.put("坐", "sit");
        map.put("手", "hand");
        map.put("腿", "leg");
    }

    //进入主循环实现接收 处理 响应
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true) {
            //接收请求
            //这是一个接受数据的缓冲区 地址是接受数据的时候有内存填充
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            //程序启动会会很快到达receive操作 如果客户端没有发送任何数据 此时receive操作会阻塞直到有客户端发送数据过来
            //当整的有哭换端发送过来数据时 receive就会将数据保证到DategramPAcket对象的缓冲区里
            socket.receive(requestPacket);
            //原本请求的数据时byte[]需要将其转换成String 并且如果发来的数据小于我们缓冲区的大小就会默认添加空格 我们得去掉无用空格
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength()).trim();
            //处理请求
            String respond = process(request);
            //把响应写回给客户端, 响应数据就是 response, 需要包装成一个 Packet 对象
            //此时这个用于send 不仅需要指定缓冲区还不要忘记在Packet对象的最后加上请求数据包里的Socket地址
            //还可以将ip和port分开写
            DatagramPacket respondPacket = new DatagramPacket(respond.getBytes(),
                    respond.getBytes().length, requestPacket.getSocketAddress());
            socket.send(respondPacket);

            //打印请求访问日志
            System.out.println(requestPacket.getAddress().toString() + "  " + requestPacket.getPort() + "  request: "
                    + request + "  respond: " + respond);
        }

    }

    private String process(String request) {

        // 由于此处是一个 echo server, 请求内容是啥, 响应内容就是啥.
        // 如果是一个更复杂的服务器, 此处就需要包含很多的业务逻辑来进行具体的计算.
        return map.getOrDefault(request, "未学习");
    }

    //一个主函数去设置该服务器的端口 并让其开始执行
    public static void main(String[] args) {
        try {
            MyUDPServer myUDPServer = new MyUDPServer(9090);
            try {
                myUDPServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
