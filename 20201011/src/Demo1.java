import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 13:26
 */
public class Demo1 {

    public static void main(String[] args) {
        //演示读读共享
        Service service = new Service();
        Thread a = new Thread("A") {
            @Override
            public void run() {
                service.read();
            }
        };
        Thread b = new Thread("B") {
            @Override
            public void run() {
                service.read();
            }
        };
        a.start();
        b.start();
    }

}
