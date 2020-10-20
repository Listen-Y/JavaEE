package service.userService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.UserDao;
import model.User;
import util.OrderSystemException;
import util.OrderSystemUtil;

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
 * Time: 14:39
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private Gson gson = new GsonBuilder().create();

    static class Request {
        public String name;
        public String password;
    }

    static class Respond {
        public int ok;
        public String reason;
        public String name;
        public int isAdmin;
    }

    //实现用户登录
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Respond respond = new Respond();
        try {
            //读取body中的数据
            String jsonStr = OrderSystemUtil.readBody(req);
            //
            //将数据构建成对象
            Request request = gson.fromJson(jsonStr, Request.class);
            //判断是否有该用户
            UserDao dao = new UserDao();
            User user = dao.findUserByName(request.name);
            if (user == null) {
                throw new OrderSystemException("账号未注册");
            }
            //判断密码是否正确
            if (!user.getPassword().equals(request.password)) {
                throw new OrderSystemException("账号或密码错误");
            }
            //新建session 登录成功
            HttpSession session = req.getSession(true);
            session.setAttribute("user", user);
            respond.ok = 1;
            respond.reason = "";
            respond.isAdmin = user.getIsAdmin();
            respond.name = user.getName();
        } catch (OrderSystemException e) {
            //登录出错了
            respond.ok = 0;
            respond.reason = e.getMessage();
        } finally {
            //返回json数据
            String jsonStr = gson.toJson(respond);
            resp.getWriter().write(jsonStr);
        }

    }

    //检测当前的登录状态
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Respond respond = new Respond();
        try {
            //检测登录状态就是检测当前浏览器是否有session
            HttpSession session = req.getSession(false);
            if (session == null) {
                //说明此时没有session 也就是说明不是登录状态
                throw new OrderSystemException("当前未登录");
            }
            //即使有session这个session是否关联了user
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("当前未登录");
            }
            //是登陆状态
            respond.ok = 1;
            respond.name = user.getName();
            respond.isAdmin = user.getIsAdmin();
            respond.reason = "";
        } catch (OrderSystemException e) {
            //是未登录状态
            respond.ok = 0;
            respond.reason = e.getMessage();
        } finally {
            //返回json数据
            String jsonStr = gson.toJson(respond);
            resp.getWriter().write(jsonStr);
        }

    }
}
