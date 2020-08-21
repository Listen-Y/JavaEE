package service;

import DynamicPage.DynamicHtmlServlet;
import model.User;
import model.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class JoinServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //首先判断输入框是否为空 如果为空报错
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        if (name== null || password == null || "".equals(name)
              || "".equals(password)) {
            String html = DynamicHtmlServlet.DynamicHtml("账号或密码错误","点击返回登录页面", "join.html");
            resp.getWriter().write(html);
            return;
        }
        //查看根据数据库查看该账号是否已经存在
        User user = UserDao.userSelect(name);
        if (user != null) {
            //该用户注册过
            if (user.getPassword().equals(password)) {
                //密码正确
                //跳转到登录页面
                String html = DynamicHtmlServlet.DynamicHtml("登录成功", "点击确认登录", "article");
                //设置session让浏览器保存账号
                HttpSession session = req.getSession(true);
                session.setAttribute("user", user);
                resp.getWriter().write(html);
            } else {
                //密码错误
                String html = DynamicHtmlServlet.DynamicHtml("账号或密码错误","点击返回登录页面", "join.html");
                resp.getWriter().write(html);
            }
        }else {
            //该用户没注册过
            String html = DynamicHtmlServlet.DynamicHtml("账号未注册","点击返回注册页面", "register.html");
            resp.getWriter().write(html);
        }

    }

}
