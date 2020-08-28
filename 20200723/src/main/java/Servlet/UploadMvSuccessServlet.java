package Servlet;

import Dao.MvDao;
import Model.Mv;
import Model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-01
 * Time: 15:13
 */
public class UploadMvSuccessServlet extends HttpServlet {

    //将文件加到数据库
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = (User) req.getSession(false).getAttribute("user");
        if (user != null) {
            String fileName =  (String) req.getSession().getAttribute("fileMvName");
            /*String[] values = fileName.split("\\.");
            String title = values[0];*/
            int index = fileName.lastIndexOf(".");
            String title = fileName.substring(0, index);
            String url = "video/" + title;
            String message = req.getParameter("message");

            Mv mv = new Mv();
            mv.setUrl(url);
            mv.setMessage(message);
            MvDao dao = new MvDao();
            if (dao.addMv(mv) != 0) {
                //输入成功 返回首页
                resp.sendRedirect("findAllMvServlet");
            }

        }

    }

}
