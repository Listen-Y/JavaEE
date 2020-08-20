import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class HttpServletTest2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String secondName = req.getParameter("secondName");
        String password = req.getParameter("password");
        resp.setContentType("text/html; charset=utf-8");

        Writer writer = resp.getWriter();
        writer.write("<html>");
        writer.write("<h1>firstName: " + firstName + "</h1");
        writer.write("<br/>");
        writer.write("<h1>secondName: " + secondName + "</h1>");
        writer.write("<br/>");
        writer.write("<h1>password: " + password + "</h1>");
        writer.write("</html>");
    }
}
