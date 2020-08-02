package Servlet;

import Dao.MvDao;
import Model.Mv;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-01
 * Time: 15:21
 */
public class DeleteMvServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            int mvId = Integer.parseInt(req.getParameter("mvId"));
            //通过mvId找到这个mv的url然后删除在数据库删除这个记录
            //删除这个文件
            MvDao dao = new MvDao();
            Mv mv = dao.findMvById(mvId);
            String url = mv.getUrl();
            if (dao.deleteMv(mvId) == 1) {
                //数据库成功删除
                File file = new File("/root/apache-tomcat-8.5.57/webapps/OnlineMusic/" + url + ".mp4");
                file.delete();
                    //文件删除成功
                    //返回首页
            }
            resp.sendRedirect("findAllMvServlet");
        }

    }
}
