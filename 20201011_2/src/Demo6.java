import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 16:03
 */
public class Demo6 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //创建俩个task
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("A 执行时间" + new Date().getTime());
                System.out.println("l love listen");
            }
        };
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("B 执行时间" + new Date().getTime());
                System.out.println("l love swy");
            }
        };
        while (true) {
            timer.schedule(timerTask, 1000, 1000);
            timer.schedule(timerTask1, 500, 500);
            timer.cancel();
        }
    }
}
