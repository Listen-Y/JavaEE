import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 14:50
 */
public class Service2 {

    private ReentrantLock reentrantLock;

    public Service2(boolean isFire) {
        this.reentrantLock = new ReentrantLock(isFire);
    }

    public void method() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " 获取锁");
        reentrantLock.unlock();
    }
}
