import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 13:27
 */
public class Service {

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void read() {
        readWriteLock.readLock().lock();
        System.out.println(Thread.currentThread().getName() + " 开始读数据 " +
                new Date().toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " 读数据完毕 " +
                    new Date().toString());
            readWriteLock.readLock().unlock();
        }
    }

    public void write() {
        readWriteLock.writeLock().lock();
        System.out.println(Thread.currentThread().getName() + " 开始写数据 " +
                new Date().toString());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " 写数据完毕 " +
                    new Date().toString());
            readWriteLock.writeLock().unlock();
        }
    }

}
