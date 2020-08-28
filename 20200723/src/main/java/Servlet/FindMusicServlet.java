package Servlet;

import Dao.MusicDao;
import Model.Music;
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
 * Time: 8:44
 */
public class FindMusicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
            String musicName = req.getParameter("musicName");
            List<Music> list = null;

            if (musicName != null) {
                list = MusicDao.selectMusicByKeyWord(musicName);
            } else {
                list = MusicDao.selectMusicList();
            }

            //利用Jackson将map转化为json对象
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(resp.getWriter(),list);

    }
}
