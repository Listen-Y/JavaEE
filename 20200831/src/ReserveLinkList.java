/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-31
 * Time: 16:03
 */
public class ReserveLinkList {

    public ListNode makeList() {
        ListNode node = new ListNode(10);
        node.next = new ListNode(20);
        node.next.next = new ListNode(30);
        node.next.next.next = new ListNode(40);
        return node;
    }

    //头插法翻转一个链表
    private ListNode head = null;
    private void addHead(int value) {
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public ListNode reserveList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        head = null;
        /*head = null;
        head = node;
        ListNode cur = node.next;
        while (cur != null) {
            addHead(cur.value);
            cur = cur.next;
        }*/
        while (node != null) {
            addHead(node.value);
            node = node.next;
        }
        return head;
    }

    public void toString(ListNode node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.value);
            builder.append(" ");
            node = node.next;
        }
        System.out.println(builder.toString());
    }

    //三下标翻转一个链表
    public ListNode reserveList2(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode nextNode = node.next;
        node.next = null;
        while (nextNode.next != null) {
            ListNode lastNode = nextNode.next;
            nextNode.next = node;
            node = nextNode;
            nextNode = lastNode;
        }
        nextNode.next = node;
        return nextNode;
    }
}
