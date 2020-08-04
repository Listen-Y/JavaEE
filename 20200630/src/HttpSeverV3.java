import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpSeverV3 {
    //设置一个静态内部类表示user
    static class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }

    private ServerSocket serverSocket;
    // session 会话. 指的就是同一个用户的一组访问服务器的操作, 归类到一起, 就是一个会话.
    // 记者来采访你, 记者问的问题就是一个请求, 你回答的内容, 就是一个响应. 一次采访过程中
    // 涉及到很多问题和回答(请求和响应), 这一组问题和回答, 就可以称为是一个 "会话" (整个采访的过程)
    // sessions 中就包含很多会话. (每个键值对就是一个会话)
    private Map<String, User> sessions = new HashMap<>();

    public HttpSeverV3(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        try {
            HttpRequest request = HttpRequest.build(clientSocket.getInputStream());
            HttpRespond respond = HttpRespond.build(clientSocket.getOutputStream());

            if (request.getMethod() != null) {

                //判断请求是什么方法 不同方法不同处理
                if ("GET".equalsIgnoreCase(request.getMethod())) {
                    doGet(request, respond);
                } else if ("POST".equalsIgnoreCase(request.getMethod())) {
                    doPost(request, respond);
                } else {
                    respond.setHeaders("Content-type", "text/html");
                    respond.setStatue(404);
                    respond.setMessage("No Found");
                    respond.setBody("<h1>NULL</h1>");
                }
                //写入
                respond.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void doPost(HttpRequest request, HttpRespond respond) throws IOException {
      if (request.getUrl().startsWith("/login")) {
          System.out.println(request);
          //判断登录名和密码是否正确
          String userName = request.getPararmeters("username");
          String password = request.getPararmeters("password");
          if ("123".equals(userName) && "aaa".equals(password)) {
              //登录成功
              respond.setStatue(200);
              respond.setMessage("OK");
              respond.setHeaders("Content-type", "text/html");
              //通过cookie让浏览器记住你
              // 现有的对于登陆成功的处理. 给这次登陆的用户分配了一个 session
              // (在 hash 中新增了一个键值对), key 是随机生成的. value 就是用户的身份信息
              // 身份信息保存在服务器中, 此时也就不再有泄露的问题了
              // 给浏览器返回的 Cookie 中只需要包含 sessionId 即可
              String sessionId = UUID.randomUUID().toString();
              sessions.put(sessionId, new User(userName, password));
              respond.setHeaders("Set-Cookie", "sessionId="+sessionId);

              InputStream inputStream = HttpSeverV3.class.getClassLoader().getResourceAsStream("LoginFinish.html");
              assert inputStream != null;
              BufferedReader bufferedReader  =new BufferedReader(new InputStreamReader(inputStream));
              String line = null;
              while ((line = bufferedReader.readLine()) != null) {
                  respond.setBody(line);
              }
              bufferedReader.close();
          } else {
              //登录失败
              respond.setStatue(200);
              respond.setMessage("OK");
              respond.setHeaders("Content-type", "text/html");
              //登录失败应该让重写登录
              InputStream inputStream = HttpSeverV3.class.getClassLoader().getResourceAsStream("Test.html");
              assert inputStream != null;
              BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
              //按行读取写入到body中
              String line = null;
              while ((line = bufferedReader.readLine()) != null) {
                  respond.setBody(line);
              }
              bufferedReader.close();
          }
      }
    }

    private void doGet(HttpRequest request, HttpRespond respond) throws IOException {
        //返回一个html文件
        if (request.getUrl().startsWith("/ok")) {

            System.out.println(request);
            //查看浏览器中是否有cookie 并且根据sessionId得到的用户的密码正确
            String sessionId = request.getCookie("sessionId");
            User user = sessions.get(sessionId);
            if (user != null && "123".equals(user.username) && "aaa".equals(user.password)) {
               //说明此时登录的用户就是主人直接返回简历
                respond.setStatue(200);
                respond.setMessage("OK");
                respond.setHeaders("Content-type", "text/html");
                InputStream inputStream = HttpSeverV3.class.getClassLoader().getResourceAsStream("LoginFinish.html");
                assert inputStream != null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //按行读取写入到body中
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    respond.setBody(line);
                }
                bufferedReader.close();

            } else {
                respond.setHeaders("Content-type", "text/html");
                respond.setStatue(200);
                respond.setMessage("Ok");
                //在这里我们先获取类对象再获取类加载器 最后根据文件名在Resource目录中找到该文件 返回其InputStream对象
                InputStream inputStream = HttpSeverV3.class.getClassLoader().getResourceAsStream("Test.html");
                assert inputStream != null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                //按行读取写入到body中
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    respond.setBody(line);
                }
                bufferedReader.close();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        HttpSeverV3 v3 = new HttpSeverV3(9090);
        v3.start();
    }
}
