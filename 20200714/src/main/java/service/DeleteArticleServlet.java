package service;

import DynamicPage.DynamicHtmlServlet;
import model.Article;
import model.ArticleDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteArticleServlet extends HttpServlet {

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
        //获取要删除文章的id
        String articleId = req.getParameter("articleId");
        if (articleId != null) {
            Article article = ArticleDao.articleSelectData(Integer.parseInt(articleId));
            if (article != null) {
                ArticleDao.articleDelete(article);
                String html = DynamicHtmlServlet.DynamicHtml("删除成功", "返回主页", "article");
                resp.getWriter().write(html);
            }
        }

    }
}
