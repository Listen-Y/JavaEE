import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-05
 * Time: 17:45
 */
public class Demo1 {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //10个都执行完才会输出下面语句
        System.out.println("结束");
    }

}
