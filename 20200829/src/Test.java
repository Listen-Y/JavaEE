import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-30
 * Time: 19:40
 */
public class Test {

    public static void main(String[] args) {
        /*List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(0, 0);
        list.size();
        list.contains(1);
        list.clear();
        list.equals(1);
        list.indexOf(1);
        list.lastIndexOf(1);
        list.remove(1);
        list.removeAll(new LinkedList<Integer>());
        list.set(1,1);
        list.toArray();*/
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(1);
        linkedList.add(0, 0);
        System.out.println(linkedList.contains(1));
        System.out.println(linkedList.indexOf(1));
        System.out.println(linkedList.lastIndexOf(0));
        linkedList.add(0);
        linkedList.set(0, 1);
        System.out.println(linkedList.toString());
        System.out.println("==================");
        linkedList.remove(1);
        System.out.println(Arrays.toString(linkedList.toArray()));
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(1);
        System.out.println(Arrays.toString(linkedList.toArray()));
        System.out.println(linkedList.size());
        System.out.println("===============");
        linkedList.removeAll(1);
        System.out.println(linkedList.size());
        System.out.println(linkedList.toString());
        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}
