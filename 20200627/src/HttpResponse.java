import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// 表示一个 HTTP 响应, 负责构造
// 进行序列化操作
public class HttpResponse {
    private String version = "HTTP/1.1";
    private int status;     // 状态码
    private String message; // 状态码的描述信息
    private Map<String, String> headers = new HashMap<>();
    private StringBuilder body = new StringBuilder(); // 方便一会进行拼接.
    // 当代码需要把响应写回给客户端的时候, 就往这个 OutputStream 中写就好了.
    private OutputStream outputStream = null;

    public static HttpResponse build(OutputStream outputStream) {
        HttpResponse response = new HttpResponse();
        response.outputStream = outputStream;
        // 除了 outputStream 之外, 其他的属性的内容, 暂时都无法确定. 要根据代码的具体业务逻辑
        // 来确定. (服务器的 "根据请求并计算响应" 阶段来进行设置的)
        return response;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    public void writeBody(String content) {
        body.append(content);
    }

    // 以上的设置属性的操作都是在内存中倒腾.
    // 还需要一个专门的方法, 把这些属性 按照 HTTP 协议 都写到 socket 中.
    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write(version + " " + status + " " + message + "\n");
        headers.put("Content-Length", body.toString().getBytes().length + "");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            bufferedWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString());
        bufferedWriter.flush();
    }
}