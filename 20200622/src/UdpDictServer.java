import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDictServer extends UDPServer {
    private Map<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);

        // 所谓 "有道词典" 实现, 本质上就是个 hash 表.
        // 只不过人家的那个 hash 非常大
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("fuck", "卧槽");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "这超出了我的知识范围");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer server = new UdpDictServer(9090);
        server.start();
    }
}