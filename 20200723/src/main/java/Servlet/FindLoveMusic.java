package Servlet;

import Dao.MusicDao;
import Model.Music;
import Model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-30
 * Time: 15:13
 */
public class FindLoveMusic extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = (User) req.getSession(false).getAttribute("user");
        if (user != null) {
            String musicName = req.getParameter("musicName");
            List<Music> list = null;

            if (musicName != null) {
                //关键字查询
                list = MusicDao.findLoveMusicByKeyWord(musicName, user.getId());
            } else {
                //查询全部
                list = MusicDao.findAllLoveMusic(user.getId());
            }

            //利用Jackson将map转化为json对象
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getWriter(),list);
        }

    }
}
