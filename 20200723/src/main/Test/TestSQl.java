/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-24
 * Time: 20:06
 */
public class TestSQl {

    public static void main(String[] args) {
      /*  String keyWords = "张杰";
        String sql = "select * from music where title like '%" + keyWords + "%'";
        System.out.println(sql);
        String sql1 = "select music.id as id, title, singer, time, url, music.userId from music, loveMusic " +
                "where music.id = loveMusic.musicId and loveMusic.userId = ? and title like '%" + keyWords + "%'";
        System.out.println(sql1);*/
      String fileName = "Morello Malt - F. Physical-La Banda（Matt Hanna Bootleg）（Morello Malt remix）.mp3";
        System.out.println(fileName.length());
        int index = fileName.lastIndexOf(".");
        String title = fileName.substring(0, index);
        System.out.println(title);
    }

}
