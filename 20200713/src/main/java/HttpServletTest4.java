import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

public class HttpServletTest4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 每秒自动刷新
        // 返回的页面中, 填写上当前时间.
        // 获取当前时间
        // System.currentTimeMillis();
        // new Date();
        // new Calender();
        resp.setContentType("text/html; charset=utf-8");
        //设置header部分 1 表示每间隔一秒
        resp.setIntHeader("Refresh", 1);
        Date date = new Date();

        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<h1>" + date.toString() + "</h1>");
        writer.write("</html>");
    }
}
