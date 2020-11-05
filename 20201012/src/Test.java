/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 17:37
 */
public class Test {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(HungryObject.getInstance().id);
            }
        };

        Thread a = new Thread(runnable);
        Thread b = new Thread(runnable);
        Thread c = new Thread(runnable);
        a.start();
        b.start();
        c.start();
    }

    public static void main1(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(LazyObject.getInstance().hashCode());
            }
        };

        Thread a = new Thread(runnable);
        Thread b = new Thread(runnable);
        Thread c = new Thread(runnable);
        a.start();
        b.start();
        c.start();
    }
}
