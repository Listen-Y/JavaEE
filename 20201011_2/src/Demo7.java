import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 16:21
 */
public class Demo7 {

    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("任务开始 " + new Date().toString());
                System.out.println(".....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("任务结束 " + new Date().toString());
            }
        };
        System.out.println("main开始时间 " + new Date().toString());
        timer.schedule(timerTask, 5000, 1000);
    }
}
