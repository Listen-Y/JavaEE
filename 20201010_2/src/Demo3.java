import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 16:59
 */
public class Demo3 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    System.out.println(reentrantLock.getWaitQueueLength(condition));
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }

    }
}
