import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    //doXX的方法对应的是http请求的的方法比如doGet就是Http的get请求
    //请求解析就是一个序列化的过程 构造响应就是个反序列化的过程
    //上述俩个过程servlet已经帮我们处理好了 分别处理形成了HttpServletRequest对象
    //和HttpServletRespond对象
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write("<h1>hello servlet</h1>");
    }
}
