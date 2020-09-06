import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-04
 * Time: 20:40
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();

        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    atomicInteger.addAndGet(1);
                }
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    atomicInteger.addAndGet(1);
                }
            }
        };

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(atomicInteger.get());
    }

}
