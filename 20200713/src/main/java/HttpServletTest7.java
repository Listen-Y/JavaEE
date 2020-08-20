import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpServletTest7 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //构建一个Cookie
        Cookie name = new Cookie("userName", "listen");
        Cookie password = new Cookie("password", "listenY");
        //把cookie写到respond中
        resp.addCookie(name);
        resp.addCookie(password);
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("<h1>设置Cookie成功</h1>");
    }
}
