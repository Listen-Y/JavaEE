import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class HttpServletTest10 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //删除现有的cookie
        //获取所有cookie 然后将这些cookie的生命时间设置为0
        //将这些cookie保存在响应报文中
        Cookie[] cookies = req.getCookies();
        // 设置响应内容类型
        resp.setContentType("text/html; charset=utf-8");

        if (cookies != null) {
            for (Cookie c : cookies
                 ) {
                c.setMaxAge(0);
                resp.addCookie(c);
            }

            Writer writer = resp.getWriter();
            writer.write("<html>");
            writer.write("<h1>删除cookie成功</h1>");
        } else {
            Writer writer = resp.getWriter();
            writer.write("<html>");
            writer.write("<h1>当前没有cookie</h1>");
        }
    }
}
