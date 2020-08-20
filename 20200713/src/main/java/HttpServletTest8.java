import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class HttpServletTest8 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获得Cookie字段
        Cookie[] cookies = req.getCookies();
        //将所有的cookie输出到响应报文中
        resp.setContentType("text/html; charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        for (Cookie c : cookies
             ) {
            writer.write("<h1>" + c.getName() + ": " + c.getValue() + "</h1>");
        }
        writer.write("</html>");
    }
}
