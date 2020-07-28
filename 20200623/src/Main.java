import java.util.HashMap;
import java.util.Map;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Main {

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(0);
        ListNode tmpA = headA;
        ListNode tmpB = headB;
        for (ListNode node = pHead; node != null; node = node.next) {
            if (node.val < x) {
                tmpA.next = node;
                tmpA = tmpA.next;
            } else {
                tmpB.next = node;
                tmpB = tmpB.next;
            }
        }
        tmpB.next = null;
        tmpA.next = headB.next;
        return headA.next;
    }

    public static int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : gifts
             ) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int count = 0;
        int money = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()
                ) {
            if (e.getValue() > count) {
                count = e.getValue();
                money = e.getKey();
            }
        }

        if (2 * count > gifts.length) {
            return money;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] gifts = new int[] {1,2,3,2,2};
        System.out.println(getValue(gifts, 5));
    }
}
