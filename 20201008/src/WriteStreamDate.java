import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 20:36
 */
public class WriteStreamDate {

    public void writeDate(PipedOutputStream pipedOutputStream) {
        System.out.println(Thread.currentThread().getName() + " 开始向管道中写东西");
        try {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                String date = ch + " ";
                    pipedOutputStream.write(date.getBytes());

            }
            pipedOutputStream.flush();
            pipedOutputStream.close();
            System.out.println(Thread.currentThread().getName() + " 写数据完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
