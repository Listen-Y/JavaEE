package service;

import DynamicPage.DynamicHtmlServlet;
import model.Article;
import model.ArticleDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ArticleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=utf-8");
        //判断是否是登录状态
        HttpSession session = req.getSession(false);
        if (session == null) {
            //未登录状态
            String html = DynamicHtmlServlet.DynamicHtml("请先登录", "点击跳转到登录页面", "join.html");
            resp.getWriter().write(html);
            return;
        }
        //获得博客主人信息
        User user = (User) session.getAttribute("user");
        //判断是否要获取文章具体内容
        String articleId = req.getParameter("articleId");
        if (articleId != null) {
            //说明要获取文章具体内容
            Article article = ArticleDao.articleSelectData(Integer.parseInt(articleId));
            assert article != null;
            String html = showOneArticleData(article, user);
            resp.getWriter().write(html);
            return;
        }
        //获得该主人的所有已发布的博文
        List<Article> list = ArticleDao.articleSelect(user.getId());
        //并将所有博文显示到浏览器
        String html = DynamicHtmlServlet.DynamicArticleHtml(user, list);
        resp.getWriter().write(html);

    }

    private String showOneArticleData(Article article, User user) {

        return "<html>" +
                "<head>" +
                "<meta charset=\"utf-8\">" +
                String.format("<title>%s</title>", user.getName() + "的博客") +
                "</head>" +
                "<body style=\"background: url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595846270292&di=a0db1d354be99ca1032e7903f898fc51&imgtype=0&src=http%3A%2F%2Fimg.netbian.com%2Ffile%2F2016%2F0515%2Fa95df86629bbf0b838b93af3788b4d72.gif); margin-top: 300px; margin-left: 200px\">" +
                String.format("<h3 style=\"font-family: impact, sans-serif;\n" +
                        "color: #EB8F8F;\n" +
                        "font-size: 30px;\n" +
                        "font-weight: bold;\n" +
                        "font-style: italic;\n" +
                        "\">%s</h3>", article.getTitle()) +
                "<div style=\"font-size: 20px\">" + article.getData().replaceAll("\\n", "<br/>") + "</div>" +
                "<br/>" +
                "<a style=\"font-family: impact, sans-serif;\n" +
                "color: #EB8F8F;\n" +
                "font-size: 30px;\n" +
                "font-weight: bold;\n" +
                "font-style: italic;\n" +
                "\" href=\"article\"> 返回主页 </a>" +
                "</body>" +
                "</html>";
    }
}
