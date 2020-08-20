import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpServletTest6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向到一个网页 这个方法自动帮我们设置了respond的状态码和状态描述等相关信息
        resp.sendRedirect("https://blog.csdn.net/Shangxingya/article/details/107295800");
    }
}
