import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 21:01
 */
public class Run2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        //创建流对象建立连接
        PipedReader pipedReader = new PipedReader();
        PipedWriter pipedWriter = new PipedWriter();
        pipedReader.connect(pipedWriter);
        //
        ReadDate readDate = new ReadDate();
        WriteDate writeDate = new WriteDate();
        //创建线程
        Thread a = new Thread("A") {
            @Override
            public void run() {
                writeDate.write(pipedWriter);
            }
        };
        Thread b = new Thread("B") {
            @Override
            public void run() {
                readDate.read(pipedReader);
            }
        };
        //
        a.start();
        Thread.sleep(100);
        b.start();
        Thread.sleep(100);
    }
}
