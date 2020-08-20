import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

public class HttpServletTest3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setContentType("text/html; charset=utf-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        //返回的是一个枚举
        Enumeration<String> enumeration = req.getHeaderNames();

        Writer writer = resp.getWriter();
        writer.write("<html>");

        while (enumeration.hasMoreElements()) {
            String header = enumeration.nextElement();

            writer.write("<h1>" + header + ": " + req.getHeader(header) + "</h1>");
        }
        writer.write("</html");
    }
}
