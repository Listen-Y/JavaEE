import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 15:55
 */
public class Demo5 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        //创建俩个task
        TimerTask timerTask = new TimerTask() {
            volatile int count = 0;
            @Override
            public void run() {
                System.out.println("A 执行时间" + new Date().getTime());
                System.out.println("l love listen");
                count++;
                if (count == 3) {
                    System.out.println("执行timer.cancel");
                    timer.cancel();
                }
            }
        };
        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("B 执行时间" + new Date().getTime());
                System.out.println("l love swy");
            }
        };
        timer.schedule(timerTask, 1000, 1000);
        timer.schedule(timerTask1, 500, 500);
    }
}
