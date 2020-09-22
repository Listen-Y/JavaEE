import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-31
 * Time: 10:57
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
/*        BlockingQueue blockingQueue = new BlockingQueue(2);
        blockingQueue.offer(1);
        System.out.println(blockingQueue.toString());
        blockingQueue.offer(2);
        System.out.println(blockingQueue.toString());
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        blockingQueue.offer(3);
        System.out.println(blockingQueue.toString());
       *//*ShellSort shellSort = new ShellSort();
       int[] array = new int[] {9,8,7,6,5,4,3,2,1};
       shellSort.shellSort(array);
        System.out.println(Arrays.toString(array));*//*
        Stack<Integer> stack = new Stack<>();*/
        ReserveLinkList linkList = new ReserveLinkList();
        ListNode node = linkList.makeList();
        linkList.toString(node);
        node = linkList.reserveList2(node);
        linkList.toString(node);

    }
}
