package Servlet;

import Dao.MusicDao;
import Dao.MvDao;
import Dao.UserDao;
import Model.Music;
import Model.Mv;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-31
 * Time: 15:54
 */
public class CancellationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //注销账号首先现在是在登录状态
        //把他喜欢的音乐和mv应该删除
        //删除这个人的user
        //设置session无效
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            List<Music> list = MusicDao.findAllLoveMusic(user.getId());
            int length = list.size();
            int count = 0;
            for (Music m : list
                 ) {
                count += MusicDao.removeLoveMusic(user.getId(), m.getId());
            }
            //删掉他所有喜欢的mv
            MvDao dao = new MvDao();
            List<Mv> listMv = dao.getAllLoveMv(user.getId());
            int size = listMv.size();
            int count1 = 0;
            for (Mv mv : listMv
                 ) {
                count1 += dao.deleteLoveMv(user.getId(), mv.getId());
            }
            if (length == count && size == count1) {
                //说明这个账号喜欢的额音乐删除完毕
                //现在开始删除这个用户
                UserDao.deleteUser(user.getId());
            }
            HttpSession session = req.getSession(false);
            if (session!= null) {
                session.invalidate();
            }
            //并且将浏览器的所有cookie删除
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies
                     ) {
                    c.setMaxAge(0);
                    resp.addCookie(c);
                }
            }
        }
        resp.sendRedirect("listen/home.html");
    }
}
