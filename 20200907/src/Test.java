/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-07
 * Time: 12:38
 */
public class Test {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我是大王");
                timer.schedule(this, 2000);
            }
        }, 2000);
    }
}
