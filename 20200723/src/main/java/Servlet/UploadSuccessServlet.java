package Servlet;

import Dao.MusicDao;
import Model.Music;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-30
 * Time: 9:18
 */
public class UploadSuccessServlet extends HttpServlet {

    //将文件加到数据库
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = (User) req.getSession(false).getAttribute("user");
        if (user != null) {
            String fileName =  (String) req.getSession().getAttribute("fileName");
            /*String[] values = fileName.split("\\.");
            String title = values[0];*/
            int index = fileName.lastIndexOf(".");
            String title = fileName.substring(0, index);
            String url = "music/" + title;
            String singer = req.getParameter("singer");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String time=sdf.format(new Date());

            Music music = new Music();
            music.setSinger(singer);
            music.setUrl(url);
            music.setTitle(title);
            music.setId(0);
            music.setTime(time);
            if (MusicDao.addMusic(music) != 0) {
                //输入成功 返回首页
                resp.sendRedirect("list.html");
            }

        }

    }
}
