import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 17:46
 */
public class Demo7 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        System.out.println(reentrantLock.isLocked());

        Thread thread = new Thread() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("执行lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("释放lock");
                    reentrantLock.unlock();
                }
            }
        };
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(reentrantLock.isLocked());
            Thread.sleep(200);
        }


    }
}
