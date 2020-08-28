package Servlet;

import Dao.MvDao;
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
 * Time: 15:49
 */
public class LoveMvServlet extends HttpServlet {

    //添加喜欢mv
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8; charset=utf-8");
        User user = (User) req.getSession().getAttribute("user");
        int mvId = Integer.parseInt(req.getParameter("mvId"));

        if (user != null) {
            MvDao dao = new MvDao();
            if (dao.addLoveMv(user.getId(), mvId) == 1) {
                System.out.println("添加喜欢成功");
            }
            //返回主页
            resp.sendRedirect("findAllMvServlet");
        }

    }
}
