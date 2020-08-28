package Servlet;

import Dao.UserDao;
import Model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-28
 * Time: 21:17
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = UserDao.selectUser(username);

        Map<String ,Object> return_map = new HashMap<>();

        if (user != null) {
            if (user.getPassword().equals(password)) {
                //说明输入的账号密码是正确的
                return_map.put("msg", "ok");
                //并且让浏览器记住这个用户 如果是新用户就让其产生一个session
                HttpSession session = req.getSession(true);
                session.setAttribute("user", user);
            } else {
                //说明密码不正确
                return_map.put("msg", false);
            }
        } else if (username != null && password != null && (username.length() != 0 || password.length() != 0)) {
            //说明未注册
            return_map.put("msg", "register");
        }

        //利用Jackson将map转化为json对象
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}
