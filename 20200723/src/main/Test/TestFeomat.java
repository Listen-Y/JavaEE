import Dao.MvDao;
import Model.Mv;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-01
 * Time: 14:29
 */
public class TestFeomat {

    public static void main(String[] args) {
        MvDao dao = new MvDao();
        Mv mv = dao.findMvById(3);

        String builder = "        <div>\n" +
                "<video src=\"" + mv.getUrl() + ".mp4\"" + " controls=\"controls\" width=20%> </video>" +
                String.format("<h3 style=\"margin-left: 30px\">%s</h3>", mv.getMessage()) +
                String.format("<a class=\"btn btn btn-primary\" " +
                        "href=\"/OnlineMusic/loveMvServlet?mvId=%d\"  >喜欢</a>", mv.getId()) +
                String.format("<span style=\"margin-left:70px\"></span><a class=\"btn btn btn-primary\" " +
                        "href=\"/OnlineMusic/deleteMvServlet?mvId=%d\"  >删除</a>", mv.getId()) +
                "\n" +
                "        </div>";
        System.out.println(builder);
    }
}
