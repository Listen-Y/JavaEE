import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-27
 * Time: 15:42
 */
//线程任务类
public class CollectionTask implements Runnable {

    private List<String> list;

    public CollectionTask(List<String> list) {
        this.list = list;
    }


    @Override
    public void run() {
        //在任务中插入名字
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.add(Thread.currentThread().getName());

    }
}
