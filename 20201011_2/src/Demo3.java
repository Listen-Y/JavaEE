import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 15:41
 */
public class Demo3 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行时间" + new Date().toString());
                System.out.println("l love listen");
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }
}
