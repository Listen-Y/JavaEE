package service.userService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import util.OrderSystemException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-15
 * Time: 14:41
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Respond {
        public int ok;
        public String reason;
    }

    //注销登录
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Respond respond = new Respond();
        try {
            //判断是不是还未登录
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登录");
            }
            //删掉session关联的user即可
            session.removeAttribute("user");
            //注销成功
            respond.ok = 1;
            respond.reason = "";
        } catch (OrderSystemException e) {
            //注销失败
            respond.reason = e.getMessage();
            respond.ok = 0;
        } finally {
            //返回json数据
            String jsonStr = gson.toJson(respond);
            resp.getWriter().write(jsonStr);
        }
    }
}
