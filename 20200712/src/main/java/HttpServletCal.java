import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpServletCal extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求中的数据
        String aStr = req.getParameter("a");
        String bStr = req.getParameter("b");
        int ret = Integer.parseInt(aStr) + Integer.parseInt(bStr);
        //将结果写回到响应报文中
        resp.getWriter().write("<h1>ret=" + ret + "</h1>");
    }
}
