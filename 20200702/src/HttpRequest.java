import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    //解析的内容
    private String method;
    private String url;
    private String version;
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> cookies = new HashMap<>();
    private Map<String, String> parameters = new HashMap<>();
    private String body;

    //使用工厂模式
    public static HttpRequest bulid(InputStream inputStream) throws IOException {
        HttpRequest request = new HttpRequest();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String firstLine = bufferedReader.readLine();
        //不为空进行解析
        if (firstLine != null) {
            //解析首行
            String[] firstLineTokens = firstLine.split(" ");
            request.method = firstLineTokens[0];
            request.url = firstLineTokens[1];
            request.version = firstLineTokens[2];
            //解析url中的键值对
            int pos = request.url.indexOf("?");
            if(pos != -1) {
                //说明url中有键值对
                String part = request.url.substring(pos + 1);
                //将键值对进行分割放到parameters中
                putKV(part, request.parameters);
            }
            //解析heater
            String line = "";
            while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
                String[] linePart = line.split(": ");
                request.headers.put(linePart[0], linePart[1]);
            }
            //解析cookie字段
            String cookie = request.headers.get("Cookie");
            if (cookie != null) {
                //说明请求中带有cookie
                putCookieKV(cookie, request.cookies);
            }
            //解析body;
            if ("post".equalsIgnoreCase(request.method)
                    || "get".equalsIgnoreCase(request.method)
            ) {
                //目前只对post和get方法中的body进行解析
                String len = request.headers.get("Content-Length");
                if (len != null) {
                    char[] buffer = new char[Integer.parseInt(len)];
                    int length = bufferedReader.read(buffer);
                    request.body = new String(buffer, 0, length);
                    //对body进行解析 这里的解析方案和对url中的键值对的解析方案是一样的
                    //System.out.println(request.body);
                    putKV(request.body, request.parameters);
                }
            }
        }
        return request;
    }

    private static void putCookieKV(String cookie, Map<String, String> cookies) {
        //先对对cookie进行; 分割
        //再按=分割
        String[] cookieParts = cookie.split("; ");
        for (String s : cookieParts
             ) {
            String[] ret = s.split("=");
            cookies.put(ret[0], ret[1]);
        }
    }

    private static void putKV(String part, Map<String, String> parameters) {
        //对parts首先进行&分割
        //在对每一部分进行=分割
        String[] parts = part.split("&");
        for (String s : parts
             ) {
            String[] ret = s.split("=");
            if (ret.length != 1) {
                parameters.put(ret[0], ret[1]);
            }
        }
    }

    //写一些get方法区获取请求中的一些内容

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getVersion() {
        return version;
    }

    public String getHeaters(String key) {
        return headers.get(key);
    }

    public String getCookie(String key) {
        return cookies.get(key);
    }

    public String getParameters(String key) {
        return parameters.get(key);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                ", cookies=" + cookies +
                ", parameters=" + parameters +
                ", body='" + body + '\'' +
                '}';
    }
}
