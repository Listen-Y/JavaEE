/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-04
 * Time: 21:57
 */
public class Run3 {

    public static void main(String[] args) throws InterruptedException {
        ServiceAdd2 serviceAdd2 = new ServiceAdd2();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    serviceAdd2.addOne();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    serviceAdd2.addHundred();
                }
            };
        }
        for (Thread t : threads
             ) {
            t.start();
        }
        for (Thread t : threads
             ) {
            t.join();
        }
    }
}
