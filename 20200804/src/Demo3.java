/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-04
 * Time: 20:53
 */
public class Demo3 {

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5000; i++) {
                    count++;
                }
            }
        };
         Thread thread1 = new Thread() {
             @Override
             public void run() {
                 for (int i = 0; i < 5000; i++) {
                     count++;
                 }
             }
         };
         thread.start();
         thread1.start();
         thread.join();
         thread1.join();
        System.out.println(count);

    }
}
