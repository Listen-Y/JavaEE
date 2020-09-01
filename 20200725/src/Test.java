import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-25
 * Time: 10:11
 */

class ListNode {
      int val;
       ListNode next = null;

   ListNode(int val) {
        this.val = val;
      }
    }
public class Test {

    public static void main(String[] args) {
     /*   int[][] mat = new int[2][1];
        mat[0][0] = 1;
        System.out.println(mat[0][0]);*/
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(0, 0);
        System.out.println(list);
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
       /*ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        return list;*/
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }


}
