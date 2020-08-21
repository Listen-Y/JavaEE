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
import java.io.Writer;

public class AddArticle extends HttpServlet {

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
        //渲染页面
        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<meta charset=\"utf-8\">");
        builder.append(String.format("<title>%s</title>", user.getName() + "的博客"));
        builder.append("</head>");
        builder.append("<body style=\"background: url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595846270292&di=a0db1d354be99ca1032e7903f898fc51&imgtype=0&src=http%3A%2F%2Fimg.netbian.com%2Ffile%2F2016%2F0515%2Fa95df86629bbf0b838b93af3788b4d72.gif); margin-top: 300px; margin-left: 200px\">");
        builder.append("<div> 发布文章 </div>");
        builder.append("<div>");
        builder.append("<form method=\"post\" action=\"addArticle\">");
        builder.append("<input type=\"text\" style=\"width: 500px; margin-bottom: 5px;\" name=\"title\" placeholder=\"请输入标题\">");
        builder.append("<br>");
        builder.append("<textarea name=\"content\" style=\"width: 500px; height: 300px;\"></textarea>");
        builder.append("<br>");
        builder.append("<input type=\"submit\" value=\"发布文章\">");
        builder.append("</form>");
        builder.append("</div>");
        builder.append("</body>");
        builder.append("</html>");
        resp.getWriter().write(builder.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        //判断是否是登录状态
        HttpSession session = req.getSession(false);
        if (session == null) {
            //未登录状态
            String html = DynamicHtmlServlet.DynamicHtml("请先登录", "点击跳转到登录页面", "join.html");
            resp.getWriter().write(html);
            return;
        }
        //判断文章是否正确
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if ("".equals(title) || "".equals(content)) {
            String html = DynamicHtmlServlet.DynamicHtml("标题或者内容为空", "点击返回", "addArticle");
            resp.getWriter().write(html);
            return;
        }
        //获得博客主人信息
        User user = (User) session.getAttribute("user");
        //创建article对象
        Article article = new Article();
        article.setId(0);
        article.setTitle(title);
        article.setData(content);
        article.setUserId(user.getId());
        ArticleDao.articleAdd(article);
        String html = DynamicHtmlServlet.DynamicHtml("文章提交成功", "点击返回主页", "article");
        resp.getWriter().write(html);

    }
}
