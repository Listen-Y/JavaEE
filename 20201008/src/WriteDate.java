import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 20:56
 */
public class WriteDate {

    public void write(PipedWriter pipedWriter) {
        System.out.println(Thread.currentThread().getName() + " 开始写数据");
        StringBuilder date = new StringBuilder();
        try {
            for (char ch = 'a'; ch <= 'g'; ch++) {
                date.append(ch);
                pipedWriter.write(date.toString() + " ");
            }
            pipedWriter.flush();
            pipedWriter.close();
            System.out.println(Thread.currentThread().getName() + " 写数据完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
