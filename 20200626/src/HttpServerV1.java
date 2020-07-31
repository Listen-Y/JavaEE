import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    // HTTP 底层要基于 TCP 来实现. 需要按照 TCP 的基本格式来先进行开发.
    private ServerSocket serverSocket = null;

    public HttpServerV1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            // 1. 获取连接
            Socket clientSocket = serverSocket.accept();
            // 2. 处理连接(使用短连接的方式实现)
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        // 由于 HTTP 协议是文本协议, 所以仍然使用字符流来处理.
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            // 下面的操作都要严格按照 HTTP 协议来进行操作.
            // 1. 读取请求并解析
            //  a) 解析首行, 三个部分使用空格切分
            String firstLine = bufferedReader.readLine();
            String[] firstLineTokens = firstLine.split(" ");
            String method = firstLineTokens[0];
            String url = firstLineTokens[1];
            String version = firstLineTokens[2];
            //  b) 解析 header, 按行读取, 然后按照冒号空格来分割键值对
            Map<String, String> headers = new HashMap<>();
            String line = "";
            // readLine 读取的一行内容, 是会自动去掉换行符的. 对于空行来说, 去掉了换行符, 就变成空字符串
            while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
                // 不能使用 : 来切分. 像 referer 字段, 里面的内容是可能包含 : .
                String[] headerTokens = line.split(": ");
                headers.put(headerTokens[0], headerTokens[1]);
            }
            //  c) 解析 body (暂时先不考虑)
            // 请求解析完毕, 加上一个日志, 观察请求的内容是否正确.
            System.out.printf("%s %s %s\n", method, url, version);
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            // 2. 根据请求计算响应
            // 不管是啥样的请求, 咱们都返回一个 hello 这样的 html
            String resp = "";
            if (url.equals("/ok")) {
                bufferedWriter.write(version + " 200 OK\n");
                resp = "<h1>hello</h1>";
            } else if (url.equals("/notfound")) {
                bufferedWriter.write(version + " 404 Not Found\n");
                resp = "<h1>not found</h1>";
            } else if (url.equals("/seeother")) {
                bufferedWriter.write(version + " 303 See Other\n");
                bufferedWriter.write("Location: http://www.sogou.com\n");
                resp = "";
            } else {
                bufferedWriter.write(version + " 200 OK\n");
                resp = "<h1>default</h1>";
            }
            // 3. 把响应写回到客户端
            bufferedWriter.write("Content-Type: text/html\n");
            bufferedWriter.write("Content-Length: " + resp.getBytes().length + "\n"); // 此处的长度, 不能写成 resp.length(), 得到的是字符的数目, 而不是字节的数目
            bufferedWriter.write("\n");
            bufferedWriter.write(resp);
            // 此处这个 flush 就算没有, 问题也不大. 紧接着
            // bufferedWriter 对象就要被关闭了. close 时就会自动触发刷新操作.
            bufferedWriter.flush();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV1 server = new HttpServerV1(9090);
        server.start();
    }
}