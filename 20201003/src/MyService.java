/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-03
 * Time: 21:17
 */
public class MyService {

    private  String lock = "123";

    public void testMethod() {

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " begin at: "
                    + System.currentTimeMillis());
            lock = "456";

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " end at: "
                    + System.currentTimeMillis());

        }

    }
}
