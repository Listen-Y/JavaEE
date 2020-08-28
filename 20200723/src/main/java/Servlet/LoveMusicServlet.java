package Servlet;

import Dao.MusicDao;
import Model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-30
 * Time: 14:48
 */
public class LoveMusicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Map<String, Object> returnMap = new HashMap<>();
        User user = (User) req.getSession().getAttribute("user");
        int id = Integer.parseInt(req.getParameter("id"));

            if (MusicDao.insertLoveMusic(user.getId(), id) != 0) {
                //添加成功
                returnMap.put("msg", true);
            } else {
                returnMap.put("msg", false);
            }

        //利用Jackson将map转化为json对象
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),returnMap);

    }
}
