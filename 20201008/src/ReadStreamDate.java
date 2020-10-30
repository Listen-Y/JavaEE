import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 20:41
 */
public class ReadStreamDate {

    public void readDate(PipedInputStream pipedInputStream) {
        System.out.println(Thread.currentThread().getName() + " 开始从管道中读数据");
        byte[] buffer = new byte[20];
        int len = -1;
        try {
            while ((len = (pipedInputStream.read(buffer))) != -1) {
                String date = new String(buffer, 0, len);
                System.out.print(date);
            }
            System.out.println();
            pipedInputStream.close();
            System.out.println(Thread.currentThread().getName() + " 读完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
