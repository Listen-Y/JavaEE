import Dao.MusicDao;
import Dao.MvDao;
import Model.Mv;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-31
 * Time: 19:33
 */
public class TestMvDao {
    @Test
    public void add() {
        Mv mv = new Mv();
        mv.setId(0);
        mv.setUrl("video\\天才");
        mv.setMessage("搞笑");
        MvDao dao = new MvDao();
        dao.addMv(mv);
        Mv mv1 = dao.findMvById(4);
        System.out.println("D:\\DownLoads\\apache-tomcat-8.5.57\\webapps\\OnlineMusic\\" + mv1.getUrl() + ".mp4");
    }
    @Test
    public void delete() {
        Mv mv = new Mv();
        mv.setId(0);
        mv.setUrl("video\\天才");
        mv.setMessage("搞笑");
        MvDao dao = new MvDao();
        System.out.println(dao.findMvById(1));
        System.out.println(dao.getAllMv());
        System.out.println(dao.getMvByKeyWord("笑"));
       dao.deleteMv(0);
    }
}
