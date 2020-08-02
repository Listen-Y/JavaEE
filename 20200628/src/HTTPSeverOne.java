import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HTTPSeverOne {

    private ServerSocket serverSocket = null;

    public HTTPSeverOne(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = this.serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(socket);
                }
            });
        }
    }

    private void process(Socket socket) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))){

            //解析首行
            String firstLine = bufferedReader.readLine();
            String[] firstLineParts = firstLine.split(" ");
            String method = firstLineParts[0];
            String url = firstLineParts[1];
            String version = firstLineParts[2];
            //解析Header
            Map<String, String> headerMap = new HashMap<>();
            String line = "";
            while ((line = bufferedReader.readLine()) != null && line.length() != 0) {
                String[] lineTokens = line.split(": ");
                headerMap.put(lineTokens[0], lineTokens[1]);
            }
            //输出请求报文看是否正确
            System.out.println(method + " " + url + " " + version);
            for (Map.Entry<String, String> entry : headerMap.entrySet()
                 ) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println();
            //解析body 暂时不考虑
            //返回响应报文
            String respons;
            if (url.equals("/ok")) {
                respons = "<h1>write a ok for you</h1>";
            } else if (url.equals("/hello")) {
                respons = "<h1>write a hello for you</h1>";
            } else {
                respons = "<h1>write null for you</h1>";
            }
            bufferedWriter.write(version + " 200 + OK\n");
            bufferedWriter.write("Content-type: " + "text/html\n");
            bufferedWriter.write("Content-length: " + respons.getBytes().length + "\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(respons);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HTTPSeverOne one = null;
        try {
            one = new HTTPSeverOne(80);
            one.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
