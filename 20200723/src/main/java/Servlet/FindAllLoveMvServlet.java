package Servlet;

import Dao.MvDao;
import Model.Mv;
import Model.User;
import Services.DynamicPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-01
 * Time: 16:03
 */
public class FindAllLoveMvServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            MvDao dao = new MvDao();
            List<Mv> list  = dao.getAllLoveMv(user.getId());
            String dynamic = DynamicPage.dynamicHtmlByLimit(list);
            Writer writer = resp.getWriter();
            writer.write(dynamic);
        }

    }

}
