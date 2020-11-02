import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 17:39
 */
public class Demo6 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        System.out.println(reentrantLock.isHeldByCurrentThread());
        reentrantLock.lock();
        System.out.println(reentrantLock.isHeldByCurrentThread());
        reentrantLock.unlock();
    }
}
