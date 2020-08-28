package Services;

import Model.Mv;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-01
 * Time: 9:01
 */
public class DynamicPage {

    public static String dynamicHtml(List<Mv> list) {

        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>MV播放页面</title>\n" +
                "    <!-- 1. 导入CSS的全局样式 -->\n" +
                "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->\n" +
                "    <script src=\"js/jquery-3.1.1.min.js\"></script>\n" +
                "\n" +
                "    <meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
                "    <style>\n" +
                "\t\t  #body{\n" +
                "\t\t\t  background-image: url(\"images/w.jpg\");\n" +
                "              background-size:100% 100%;\n" +
                "              background-attachment: fixed;\n" +
                "      }\n" +
                "      </style>\n" +
                "    <!-- 3. 导入bootstrap的js文件 -->\n" +
                "    <style type=\"text/css\">\n" +
                "        td, th {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .mydiv {\n" +
                "            width: 1000px;\n" +
                "            height: 1000px;\n" +
                "            position: absolute;\n" +
                "            left: 200px;\n" +
                "            top: 130px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body id=\"body\">\n" +
                "<div class=\"container\">\n" +
                "    <h3 style=\"text-align: center\">MV播放首页</h3>\n" +
                "    <div style=\"float: left;\">\n" +
                "    </div>\n" +
                "    <div style=\"float: right;margin-bottom: 15px\">\n" +
                "        <a class=\"btn btn-primary\" href=\"/OnlineMusic/list.html\">回到首页</a>\n" +
                "        <a class=\"btn btn-primary\" href=\"/OnlineMusic/findAllLoveMvServlet\">我喜欢的MV</a>\n" +
                "        <a class=\"btn btn-primary\" href=\"/OnlineMusic/uploadVideo.html\">添加MV</a>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"mydiv\">\n");
        for (Mv mv : list
             ) {
            builder.append("        <div style=\"padding-left:200px\">\n");
            builder.append(String.format("            <h3 style=\"margin-left: 30px\">%s</h3>", mv.getMessage()));
            builder.append("<video src=\"").append(mv.getUrl()).append(".mp4\"").append(" controls=\"controls\" width=30%> </video>");
            builder.append(String.format("<a class=\"btn btn btn-primary\" " +
                    "href=\"/OnlineMusic/loveMvServlet?mvId=%d\"  >喜欢</a>", mv.getId()));

            builder.append(String.format("<span style=\"margin-left:70px\"></span><a class=\"btn btn btn-primary\" " +
                    "href=\"/OnlineMusic/deleteMvServlet?mvId=%d\"  >删除</a>", mv.getId()));
            builder.append("\n" +
                    "        </div>");
            builder.append("<br/>");
        }

                  builder.append("    </div>\n" +
                          "\n" +
                          "</div>\n" +
                          "</body>\n" +
                          "</html>")  ;
        return builder.toString();

    }


    public static String dynamicHtmlByLimit(List<Mv> list) {


        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>MV播放页面</title>\n" +
                "    <!-- 1. 导入CSS的全局样式 -->\n" +
                "    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
                "    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->\n" +
                "    <script src=\"js/jquery-3.1.1.min.js\"></script>\n" +
                "\n" +
                "    <meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
                "    <style>\n" +
                "\t\t  #body{\n" +
                "\t\t\t  background-image: url(\"images/w.jpg\");\n" +
                "              background-size:100% 100%;\n" +
                "              background-attachment: fixed;\n" +
                "      }\n" +
                "      </style>\n" +
                "    <!-- 3. 导入bootstrap的js文件 -->\n" +
                "    <style type=\"text/css\">\n" +
                "        td, th {\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .mydiv {\n" +
                "            width: 1000px;\n" +
                "            height: 1000px;\n" +
                "            position: absolute;\n" +
                "            left: 200px;\n" +
                "            top: 130px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body id=\"body\">\n" +
                "<div class=\"container\">\n" +
                "    <h3 style=\"text-align: center\">MV喜欢列表</h3>\n" +
                "    <div style=\"float: left;\">\n" +
                "    </div>\n" +
                "    <div style=\"float: right;margin-bottom: 15px\">\n" +
                "        <a class=\"btn btn-primary\" href=\"/OnlineMusic/findAllMvServlet\">回到首页</a>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"mydiv\">\n");
        for (Mv mv : list
        ) {
            builder.append("        <div style=\"padding-left:200px\">\n");
            builder.append("<video src=\"").append(mv.getUrl()).append(".mp4\"").append(" controls=\"controls\" width=30%> </video>");
            builder.append(String.format("<span style=\"margin-left:70px\"></span><a class=\"btn btn btn-primary\" " +
                    "href=\"/OnlineMusic/deleteLoveMvServlet?mvId=%d\"  >移除喜欢</a>", mv.getId()));
            builder.append("\n" +
                    "        </div>");
            builder.append("<br/>");
        }

        builder.append("    </div>\n" +
                "\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>")  ;
        return builder.toString();

    }

}
