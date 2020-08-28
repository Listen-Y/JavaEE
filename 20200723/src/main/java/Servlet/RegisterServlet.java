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
 * Date: 2020-07-29
 * Time: 18:44
 */
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = UserDao.selectUser(username);

        Map<String ,Object> return_map = new HashMap<>();
        if (username != null && password != null && username.length() != 0 && password.length() != 0) {
            if (user != null) {
                //账号已被注册
                return_map.put("msg", false);
            } else {
                //账号写入user表
                User user1 = new User();
                user1.setId(0);
                user1.setName(username);
                user1.setPassword(password);
                UserDao.addUser(user1);
                //给前端返回数据
                return_map.put("msg", true);
            }
        } else {
            return_map.put("msg", false);
        }
        //利用Jackson将map转化为json对象
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),return_map);

    }
}
