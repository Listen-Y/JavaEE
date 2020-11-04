import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 15:51
 */
public class Demo4 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {

            volatile int count = 0;

            @Override
            public void run() {
                System.out.println("执行时间" + new Date().toString());
                System.out.println("l love listen");
                count++;
                if (count == 3) {
                    System.out.println("执行cancel");
                    this.cancel();
                }
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }
}
