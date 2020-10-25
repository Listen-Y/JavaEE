import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 18:19
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " 开始时间:" +
                System.currentTimeMillis());
        condition.await(3, TimeUnit.SECONDS);
        System.out.println(Thread.currentThread().getName() + " 结束时间:" +
                System.currentTimeMillis());
        reentrantLock.unlock();


    }
}
