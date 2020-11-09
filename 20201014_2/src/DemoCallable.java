import javax.swing.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-14
 * Time: 19:55
 */
public class DemoCallable {

    //shutdown就是停止接受任务, 但是当前队列等待执行的任务还是会去执行
    //shutdownNow就是停止接受任务, 但是将等待的任务也是去打断
    //所以他俩的区别就在于对已经加进去但是还没有执行结束的任务, 一个是等待其执行完
    //一个是也打断
    //但是他俩有一个条件是只是去打断一下, 但并不会使这个线程去立即停止
    //如果想要线程立即停止并且在代码中加判断
    public static void main(String[] args) {



    }
}

class TimerDelay extends JFrame {

    public JLabel houserl

    public TimerDelay () {
        this.setSize(400, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        this.setVisible(true);
    }

    private void init() {

    }
}
