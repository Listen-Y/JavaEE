import Dao.MusicDao;
import Model.Music;
import sun.security.provider.MD2;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-28
 * Time: 18:16
 */
public class TestMusicDao {

    public static void main(String[] args) {

        Music music = new Music();
        music.setId(1);
        music.setTitle("十九岁");
        music.setUrl("music\\赵雷 - 十九岁");
        music.setTime("2020-01-01");
        music.setSinger("赵雷");
        MusicDao.addMusic(music);
        //MusicDao.addMusic(music1);
        //System.out.println(MusicDao.selectMusicByKeyWord("a"));
        /*System.out.println(MusicDao.selectMusicById(1));
        System.out.println(MusicDao.selectMusicById(2));*/
        //System.out.println(MusicDao.selectMusicList());
        //MusicDao.deleteMusicById(4);
        //MusicDao.insertLoveMusic(1, 6);
        //MusicDao.insertLoveMusic(1, 6);
        //MusicDao.deleteMusicById(1);
        //MusicDao.removeLoveMusic(1, 6);
        //System.out.println(MusicDao.findMusicByMusicId(1, 6));
        //System.out.println(MusicDao.findAllLoveMusic(1));
        //System.out.println(MusicDao.findLoveMusicByKeyWord("a", 1));
    }
}
