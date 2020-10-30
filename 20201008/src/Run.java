import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 20:45
 */
public class Run {

    public static void main(String[] args) throws IOException, InterruptedException {
        //创建流对象
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        //建立连接
        pipedInputStream.connect(pipedOutputStream);
        //或者
        //pipedOutputStream.connect(pipedInputStream);

        WriteStreamDate writeStreamDate = new WriteStreamDate();
        ReadStreamDate readStreamDate = new ReadStreamDate();
        //创建俩个线程
        Thread a = new Thread("A") {
            @Override
            public void run() {
                writeStreamDate.writeDate(pipedOutputStream);
            }
        };
        Thread b = new Thread("B") {
            @Override
            public void run() {
                readStreamDate.readDate(pipedInputStream);
            }
        };
        b.start();
        Thread.sleep(100);
        a.start();
        Thread.sleep(100);

    }
}
