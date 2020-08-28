package Servlet;

import Dao.MusicDao;
import Model.Music;
import Model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-30
 * Time: 14:38
 */
public class DeleteSelMusicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        Map<String, Object> returnMap = new HashMap<>();
        User user = (User) req.getSession().getAttribute("user");

        if (user != null && user.getName().charAt(0) == '#') {
            String[] values = req.getParameterValues("id[]");
            int count = 0;

            for (String value : values) {
                int id = Integer.parseInt(value);
                Music music = MusicDao.selectMusicById(id);
                if (music != null) {
                    if (MusicDao.deleteMusicById(id) == 1) {
                        //同时还要删除服务器上的这首歌
                        File file = new
                                File("/root/apache-tomcat-8.5.57/webapps/OnlineMusic/" + music.getUrl() + ".mp3");
                        if (file.delete()) {
                            count++;
                        }
                    }
                }
            }
            if (count == values.length) {
                returnMap.put("msg", true);
            } else {
                returnMap.put("msg", false);
            }
        } else {
            returnMap.put("msg", "error");
        }
        //利用Jackson将map转化为json对象
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(),returnMap);

    }
}
