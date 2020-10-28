import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-04
 * Time: 22:26
 */
public class ServiceResources {

    private List<String> list = new ArrayList<>();

    synchronized public void push() throws InterruptedException {
        if (list.size() > 0) {
            //说明有产品
            System.out.println(Thread.currentThread().getName() + " 生产者进入睡眠");
                this.wait();
        }
        System.out.println(Thread.currentThread().getName() + " 生产");
        list.add("anything");
        this.notifyAll();
    }

    synchronized public void take() throws InterruptedException {
        if (list.size() == 0) {
            //说明此时没有产品
            System.out.println(Thread.currentThread().getName() + " 消费者进入睡眠");
                this.wait();

        }
        System.out.println(Thread.currentThread().getName() + " 消费");
        list.remove(0);
        this.notifyAll();
    }

}
