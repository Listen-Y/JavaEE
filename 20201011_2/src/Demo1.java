import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 14:42
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer(true);
        Task task = new Task();
        timer.schedule(task, 1000);

        Thread.sleep(1000);
    }
}

class Task extends TimerTask {

    @Override
    public void run() {
        System.out.println("Listen");
    }
}
