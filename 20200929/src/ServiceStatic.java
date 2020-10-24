/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-29
 * Time: 11:39
 */
public class ServiceStatic {

    public synchronized static void printA() {
        System.out.println(System.currentTimeMillis() + "进入printA_Static");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + "离开printA_Static");
    }

    public synchronized static void printB() {
        System.out.println(System.currentTimeMillis() + "进入printB_Static");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + "离开printB_Static");
    }

    public void printC() {
        System.out.println(System.currentTimeMillis() + "进入printC");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + "离开printC");
    }
}
