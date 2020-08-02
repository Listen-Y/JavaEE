import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HTTPRespondHealper {
    //返回响应
    private String version;
    private int status;
    private String message;
    private Map<String, String> headers = new HashMap<>();
    private StringBuilder body = new StringBuilder();
    private OutputStream outputStream = null;

    //还是使用工厂模式
    public static HTTPRespondHealper bulid(OutputStream outputStream) {
        HTTPRespondHealper respond = new HTTPRespondHealper();
        respond.outputStream = outputStream;
        //其他东西需要通过该对象的set方法去单独设置
        return respond;
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

    public void setHeaders(String key, String value) {
        this.headers.put(key, value);
    }

    public void setBody(String body) {
        this.body.append(body);
    }

    //将对象的所有数据都写入到socket对象中
    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.outputStream));

        this.headers.put("Content-Length", body.toString().getBytes().length + "");

        bufferedWriter.write(version + " " + status + " " + message + "\n");
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            bufferedWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        bufferedWriter.write("\n");
        bufferedWriter.write(body.toString() + "\n");
        bufferedWriter.flush();
    }
}
