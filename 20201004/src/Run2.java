/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-04
 * Time: 21:49
 */
public class Run2 {

    public static void main(String[] args) throws InterruptedException {
        ServiceAtomic atomic = new ServiceAtomic();

        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        atomic.add();
                    }
                }
            };
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
        for (Thread t : threads
        ) {
            t.join();
        }
        System.out.println(atomic.count);
    }

}
