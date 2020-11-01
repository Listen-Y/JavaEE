import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 14:41
 */
public class Service {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public void methodA() {
        reentrantLock.lock();

        System.out.println(Thread.currentThread().getName() + " 进入lock");
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
        System.out.println(Thread.currentThread().getName() + " 离开lock");

        reentrantLock.unlock();
    }
}
