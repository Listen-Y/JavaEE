import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;

public class HttpServletTest9 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 先获取 Session. 如果用户曾经没有访问过, 此时将创建新的 session
        //    如果用户已经访问过了, 就获取到曾经的 Session
        //    新用户访问:
        //    这个操作就会自动生成一个 sessionId, 同时创建一个 httpSession 对象
        //    把这个键值对放到内置的 hash 表中. 同时把 sessionId 写回到浏览器的
        //    Cookie 中
        //    老用户访问:
        //    根据请求中 Cookie 里的 sessionId, 在 hash 表中查, 找到对应的 session 对象
        HttpSession session = req.getSession(true);
        // 2.判断是否为新用户
        Integer count = 1;
        if (session.isNew()) {
            //新用户
            // 把 count 值写入到 session 对象中.
            // httpSession 也可以当成是一个 hash 表.
            session.setAttribute("count", count);
        } else {
            // 老用户
            // 从 httpSession 中读取到 count 值
            count = (Integer) session.getAttribute("count");
            count++;
            session.setAttribute("count", count);
        }
        resp.setContentType("text/html; charset=utf-8");
        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<h1>" + session.getAttribute("count").toString() + "</h1>");
        writer.write("</html>");

    }
}
