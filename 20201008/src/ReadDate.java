import java.io.IOException;
import java.io.PipedReader;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 20:53
 */
public class ReadDate {

    public void read(PipedReader pipedReader) {
        System.out.println(Thread.currentThread().getName() + " 开始读数据");
        char[] buffer = new char[20];
        int len = -1;
        try {
            while ((len = pipedReader.read(buffer)) != -1) {
                String date = new String(buffer, 0, len);
                System.out.println(date);
            }
            pipedReader.close();
            System.out.println(Thread.currentThread().getName() + " 读数据完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
