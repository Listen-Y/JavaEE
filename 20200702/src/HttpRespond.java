import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class HttpRespond {
    private String version = "HTTP/1.1";
    private int status;
    private String message;
    private Map<String, String> heaters = new HashMap<>();
    private StringBuilder body = new StringBuilder();
    private OutputStream outputStream;

    //采用工厂模式
    public static HttpRespond build(OutputStream outputStream) {
        HttpRespond respond = new HttpRespond();
        respond.outputStream = outputStream;
        return respond;
    }

    //设置一些set方法区构造响应报文

    public void setVersion(String version) {
        this.version = version;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setHeaters(String key, String value) {
        this.heaters.put(key, value);
    }

    public void setBody(String body) {
        this.body.append(body);
    }

    //将响应数据写到socket对象中
    public void flush() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(this.outputStream));
        this.heaters.put("Content-Length", this.body.toString().getBytes().length + "");
        //写入首行
        bufferedWriter.write(this.version + " " + this.status + " " + this.message + "\n");
        //写入heaters
        for (Map.Entry<String, String> entry : this.heaters.entrySet()
             ) {
            bufferedWriter.write(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        //写入body
        bufferedWriter.write("\n");
        bufferedWriter.write(this.body.toString() + "\n");
        //处理缓冲区
        bufferedWriter.flush();
    }
}
