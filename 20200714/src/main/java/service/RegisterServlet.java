package service;

import DynamicPage.DynamicHtmlServlet;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //判断输入框中的数据是否为空
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name== null || password == null || "".equals(name)
                || "".equals(password)) {
            String html = DynamicHtmlServlet.DynamicHtml("账号或密码错误","点击返回注册页面", "register.html");
            resp.getWriter().write(html);
            return;
        }
        //查看数据库是否已有这个账号
        User user = UserDao.userSelect(name);
        if (user != null) {
            //账号重复
            String html = DynamicHtmlServlet.DynamicHtml("账号重复","点击返回注册页面", "register.html");
            resp.getWriter().write(html);
        } else {
            //注册成功
            User user1 = new User();
            user1.setName(name);
            user1.setPassword(password);
            UserDao.userAdd(user1);
            String html = DynamicHtmlServlet.DynamicHtml("账号注册成功","点击跳转到登录", "join.html");
            resp.getWriter().write(html);
        }

    }
}
