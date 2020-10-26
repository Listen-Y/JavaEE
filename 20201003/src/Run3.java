/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-03
 * Time: 21:50
 */
public class Run3 {

    public static void main(String[] args) throws InterruptedException {
        User user = new User("listen", 20);
        Service service = new Service();

        Thread t1 = new Thread("A") {
            @Override
            public void run() {
                service.testMethod(user);
            }
        };
        Thread t2 = new Thread("B") {
            @Override
            public void run() {
                service.testMethod(user);
            }
        };
        t1.start();
        //关键点
        Thread.sleep(100);
        t2.start();
    }
}
