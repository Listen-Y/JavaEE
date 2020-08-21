package DynamicPage;

import model.Article;
import model.User;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

public class DynamicHtmlServlet {

    public static String DynamicHtml(String message,String keyWords, String URL) {

        return "<html>" +
                "<head>" +
                "<meta charset=\"utf-8\">" +
                "<title>提示页面</title>" +
                "</head>" +
                "<body " +
                "style=\"background: url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595846270292&di=a0db1d354be99ca1032e7903f898fc51&imgtype=0&src=http%3A%2F%2Fimg.netbian.com%2Ffile%2F2016%2F0515%2Fa95df86629bbf0b838b93af3788b4d72.gif); " +
                "margin-top: 300px; margin-left: 200px\">" +
                "<h3 style=\"font-family: impact, sans-serif;\n" +
                "color: #EB8F8F;\n" +
                "font-size: 30px;\n" +
                "font-weight: bold;\n" +
                "font-style: italic;\n" +
                "\">" +
                message +
                "</h3>" +

                String.format("<a style=\"font-size: 30px\" href=\"%s\"> %s </a>",
                        URL, keyWords) +
                "</body>" +
                "</html>";

    }

    public static String DynamicArticleHtml(User user, List<Article> list) throws UnsupportedEncodingException {

        StringBuilder builder = new StringBuilder();
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<meta charset=\"utf-8\">");
        builder.append(String.format("<title>%s</title>", user.getName() + "的博客"));
        builder.append("</head>");
        builder.append("<body style=\"background: url(https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1595846270292&di=a0db1d354be99ca1032e7903f898fc51&imgtype=0&src=http%3A%2F%2Fimg.netbian.com%2Ffile%2F2016%2F0515%2Fa95df86629bbf0b838b93af3788b4d72.gif); margin-top: 300px; margin-left: 200px\">");
        builder.append(String.format("<h3 style=\"font-family: impact, sans-serif;\n" +
                "color: #B30C0C;\n" +
                "font-size: 30px;\n" +
                "font-weight: bold;\n" +
                "font-style: italic;\n" +
                "\">%s</h3>", user.getName() + "个人博客"));
        builder.append("<a style=\"font-family: impact, sans-serif;\n" +
                "color: #EB8F8F;\n" +
                "font-size: 30px;\n" +
                "font-weight: bold;\n" +
                "font-style: italic;\n" +
                "\" href=\"addArticle\"> 写博客 </a>");
        builder.append("<br/>");
        //builder.append("-------------");
        for (Article a : list
                ) {
            builder.append(String.format("<a style=\"font-family: impact, sans-serif;\n" +
                            "color: #A6559C;\n" +
                            "font-size: 30px;\n" +
                            "font-weight: bold;\n" +
                            "font-style: italic;\n" +
                            "\" href=\"article?articleId=%d\"> %s </a>", a.getId(),
                    a.getTitle()));
            builder.append(String.format("<a style=\"font-family: impact, sans-serif;\n" +
                    "color: #EB8F8F;\n" +
                    "font-size: 30px;\n" +
                    "font-weight: bold;\n" +
                    "font-style: italic;\n" +
                    "\" href=\"deleteArticle?articleId=%d\"> __删除 </a>", a.getId() ));
            builder.append("<br/>");
        }
        builder.append("</body>");
        builder.append("</html>");
        return builder.toString();

    }
}
