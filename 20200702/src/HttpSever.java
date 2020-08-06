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

public class HttpSever {

    static class User {
        public String username;
        public String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    private ServerSocket serverSocket;
    //将会话存储在服务器中
    private Map<String, User> sessions = new HashMap<>();

    public HttpSever(int port) throws IOException {
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
            HttpRequest request = HttpRequest.bulid(clientSocket.getInputStream());
            HttpRespond respond = HttpRespond.build(clientSocket.getOutputStream());

            if (request.getMethod() != null) {
                System.out.println(request);

                if ("post".equalsIgnoreCase(request.getMethod())) {
                    doPOST(request, respond);
                } else if ("get".equalsIgnoreCase(request.getMethod())) {
                    doGET(request, respond);
                } else {
                    respond.setStatus(404);
                    respond.setMessage("No Found");
                    respond.setHeaters("Content-type", "text/html");
                    respond.setBody("客户端错误");
                }

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

    private void doGET(HttpRequest request, HttpRespond respond) throws IOException {
        if (request.getUrl().equalsIgnoreCase("/root")) {
            String cookie = request.getHeaters("Cookie");
            if (cookie == null) {
                //进入登录页面
                respond.setStatus(200);
                respond.setMessage("OK");

                //将登录要页面写入到respond的body中
                InputStream inputStream = HttpRequest.class.getClassLoader().getResourceAsStream("Root.html");
                assert inputStream != null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    //System.out.println(line + "\n");
                    respond.setBody(line + "\n");
                }
                bufferedReader.close();
            } else {
                //说明此时请求报文里有cookie字段
                String sessionId = request.getCookie("sessionId");
                User user = sessions.get(sessionId);
                if (user != null && "123".equals(user.username) && "aaa".equals(user.password)) {
                    //说明此时cookie中的账号和密码时匹配的
                    //将登陆成功页面传给body中
                    respond.setStatus(200);
                    respond.setMessage("OK");
                    respond.setHeaters("Content-type", "text/html");
                    InputStream inputStream = HttpSever.class.getClassLoader().getResourceAsStream("Join.html");
                    assert inputStream != null;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        respond.setBody(line + "\n");
                    }
                    bufferedReader.close();
                } else {
                    //说明此时有cookie但是此时的cookie信息不正确
                    //还是让其登录
                    //进入登录页面
                    respond.setStatus(200);
                    respond.setMessage("OK");
                    respond.setHeaters("Content-type", "text/html");
                    //将登录要页面写入到respond的body中
                    InputStream inputStream = HttpRequest.class.getClassLoader().getResourceAsStream("Root.html");
                    assert inputStream != null;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        //System.out.println(line + "\n");
                        respond.setBody(line + "\n");
                    }
                    bufferedReader.close();
                }
            }
        } else {
            //此时不管什么都应该跳转到root登录页面
            respond.setStatus(302);
            respond.setMessage("OK");
            respond.setHeaters("Content-type", "text/html");
            respond.setHeaters("location", "http://127.0.0.1:9090/root");
        }
    }

    private void doPOST(HttpRequest request, HttpRespond respond) throws IOException {
        //如果点击登录就会进入post方法里
        String cookie = request.getHeaters("Cookie");
        if (cookie != null) {
            //说明此时请求报文里有cookie字段
            String sessionId = request.getCookie("sessionId");
            User user = sessions.get(sessionId);
            if ("123".equals(user.username) && "aaa".equals(user.password)) {
                //说明此时cookie中的账号和密码时匹配的
                //将登陆成功页面传给body中
                respond.setStatus(200);
                respond.setMessage("OK");
                respond.setHeaters("Content-type", "text/html");
                InputStream inputStream = HttpSever.class.getClassLoader().getResourceAsStream("Join.html");
                assert inputStream != null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    respond.setBody(line + "\n");
                }
                bufferedReader.close();
            } else {
                //说明此时有cookie但是此时的cookie信息不正确
                //还是让其登录
                //进入登录页面
                respond.setStatus(200);
                respond.setMessage("OK");
                respond.setHeaters("Content-type", "text/html");
                //将登录要页面写入到respond的body中
                InputStream inputStream = HttpRequest.class.getClassLoader().getResourceAsStream("Root.html");
                assert inputStream != null;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    //System.out.println(line + "\n");
                    respond.setBody(line + "\n");
                }
                bufferedReader.close();
            }
        } else {
            //说明此时是没有cookie字段的
            //读取此时输入的账号密码信息 看是否正确
            String username = request.getParameters("username");
            String password = request.getParameters("password");
            if (username == null || password == null) {
                //只要有一个为空 那么就是客户端错误
                respond.setStatus(404);
                respond.setMessage("No Found");
                respond.setHeaters("Content-type", "text/html; charset=UTF-8");
                respond.setBody("客户端错误");
            } else {
                //此时说明输入了账户和密码 需要验证其正确性
                if (username.equals("123") && password.equals("aaa")) {
                    //此时说明账户密码正确
                    //将登陆成功页面传给respond
                    //同时需要将账号密码写成cookie传给respond
                    respond.setStatus(200);
                    respond.setMessage("OK");
                    respond.setHeaters("Content-type", "text/html");
                    String sessionId = UUID.randomUUID().toString();
                    User user = new User(username, password);
                    this.sessions.put(sessionId, user);
                    respond.setHeaters("Set-Cookie", "sessionId=" + sessionId);
                    InputStream inputStream = HttpSever.class.getClassLoader().getResourceAsStream("Join.html");
                    assert inputStream != null;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        respond.setBody(line +"\n");
                    }
                    bufferedReader.close();
                } else {
                    //此时说明账号密码虽然岁输入了但是不正确
                    respond.setStatus(200);
                    respond.setMessage("OK");
                    respond.setHeaters("Content-type", "text/html");
                    InputStream inputStream = HttpSever.class.getClassLoader().getResourceAsStream("Fake.html");
                    assert inputStream != null;
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        respond.setBody(line +"\n");
                    }
                    bufferedReader.close();
                }
            }
        }
    }


    public static void main(String[] args) {
        HttpSever sever = null;
        try {
            sever = new HttpSever(9090);
            sever.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
