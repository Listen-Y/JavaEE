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
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-15
 * Time: 14:40
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Request {
        public String name;
        public String password;
    }

    static class Respond {
        public int ok;
        public String reason;
    }

    //实现用户注册
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Respond respond = new Respond();
        try {
            //获得body
            String jsonStr = OrderSystemUtil.readBody(req);
            //构建对象
            Request request = gson.fromJson(jsonStr, Request.class);
            //判断是否已有该账号
            UserDao dao = new UserDao();
            User user = dao.findUserByName(request.name);
            if (user != null) {
                //说明该账号已存在
                throw new OrderSystemException("该账号已存在");
            }
            //判断账号密码是否合法
            if (unLegal(request.name, request.password)) {
                //返回true说明填写的账号密码不合法
                throw new OrderSystemException("账号不得少于六位,密码不能有汉字");
            }
            //成功注册
            User user1 = new User();
            user1.setIsAdmin(0);
            user1.setPassword(request.password);
            user1.setName(request.name);
            dao.addUSer(user1);
            //构建respond
            respond.ok = 1;
            respond.reason = "";
        } catch (OrderSystemException e) {
            //出错了返回错误
            respond.reason = e.getMessage();
            respond.ok = 0;
        } finally {
            //返回json数据
            String jsonStr = gson.toJson(respond);
            resp.getWriter().write(jsonStr);
        }
    }

    private boolean unLegal(String name, String password) {
        if (name == null || name.length() < 6) {
            return true;
        }
        return password.getBytes().length != password.length();
    }
}
