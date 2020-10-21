import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-27
 * Time: 15:41
 */
//测试类
public class ArrayListSafetyTest {

    public static void main(String[] args) {
        List<String> list = new Vector<>();
        //重点
        //list = Collections.synchronizedList(list);
        CollectionTask task = new CollectionTask(list);
        for (int i = 0; i < 50; i++) {
            new Thread(task).start();
        }
        //等待线程执行
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //遍历链表
        for (String str : list
             ) {
            System.out.println(str);
        }


    }
}
