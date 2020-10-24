import javax.net.ssl.SSLContext;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-29
 * Time: 11:41
 */
public class Run5 {

    public static void main(String[] args) {

        Thread thread = new Thread("A") {

            @Override
            public void run() {
                while (true) {
                    ServiceStatic.printA();
                }
            }
        };

        Thread thread1 = new Thread("B") {
            @Override
            public void run() {
                while (true) {
                    ServiceStatic.printB();
                }
            }
        };

        ServiceStatic serviceStatic = new ServiceStatic();
        Thread thread2 = new Thread("C") {
            @Override
            public void run() {

                while (true) {
                    serviceStatic.printA();
                }
            }
        };
        thread.start();
        thread1.start();
        thread2.start();
    }
}
