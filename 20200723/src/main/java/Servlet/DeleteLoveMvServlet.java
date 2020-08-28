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
 * Time: 16:07
 */
public class DeleteLoveMvServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("utf-8; charset=utf-8");
        User user = (User) req.getSession().getAttribute("user");
        int mvId = Integer.parseInt(req.getParameter("mvId"));

        if (user != null) {
            MvDao dao = new MvDao();
            if (dao.deleteLoveMv(user.getId(), mvId) == 1) {
                System.out.println("删除喜欢Mv成功");
            } else {
                System.out.println("删除喜欢Mv失败");
            }
            //返回喜欢列表
            resp.sendRedirect("findAllLoveMvServlet");
        }

    }
}
