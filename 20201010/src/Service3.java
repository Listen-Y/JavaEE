import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 15:07
 */
public class Service3 {

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public void methodAwait() {
        System.out.println(Thread.currentThread().getName() + " 开始运行");
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " 执行await");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + " 运行结束");
        }
    }

    public void methodSignal() {
        System.out.println(Thread.currentThread().getName() + " 开始运行");
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " 执行signal");
        try {
            condition.signal();
        } finally {
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + " 运行结束");
        }
    }
}
