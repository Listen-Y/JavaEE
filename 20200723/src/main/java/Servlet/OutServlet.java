package Servlet;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-31
 * Time: 9:59
 */
public class OutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //将浏览器的session的设置为无效 然后返回登录页面
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
            //并且将浏览器的所有cookie删除
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies
                     ) {
                    c.setMaxAge(0);
                    resp.addCookie(c);
                }
            }
            resp.sendRedirect("listen/home.html");
        }

    }
}
