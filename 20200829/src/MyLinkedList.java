import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-30
 * Time: 19:39
 */
class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
public class MyLinkedList {

    private ListNode head;
    private int size = 0;

    //add
    public void add(int value) {
        ListNode node = new ListNode(value);
        if (this.head == null) {
            this.head = node;
            size++;
            return;
        }
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        size++;
    }

    //addIndex
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode node = new ListNode(value);
        if (index == 0) {
            if (this.head != null) {
                node.next = this.head;
            }
            this.head = node;
            this.size++;
            return;
        }
        ListNode cur = this.head;
        int count = 0;
        while (count < index - 1) {
            cur = cur.next;
            count++;
        }
        node.next = cur.next;
        cur.next = node;
        size++;
    }
    //size
    public int size() {
        return this.size;
    }
    //contains
    public boolean contains(int value) {
        if (size == 0) {
            return false;
        }
        for (ListNode cur = this.head; cur != null ; cur = cur.next) {
            if (cur.value == value) {
                return true;
            }
        }
        return false;
    }
    //clear
    public void clear() {
        this.size = 0;
        this.head = null;
    }
    //indexOf
    public int indexOf(int value) {
        if (this.size == 0) {
            return -1;
        }
        int index = 0;
        for (ListNode cur = this.head; cur != null; cur = cur.next) {
            if (cur.value == value) {
                return index;
            }
            index++;
        }
        return -1;
    }
    //lastIndexOf
    public int lastIndexOf(int value) {
        if (this.size == 0) {
            return -1;
        }
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (ListNode cur = this.head; cur != null; cur = cur.next) {
            if (cur.value == value) {
                stack.push(index);
            }
            index++;
        }
        return stack.pop();
    }
    //remove
    public void remove(int value) {
        if (this.size == 0) {
            return;
        }
        if (this.head.value == value) {
            this.head = this.head.next;
            size--;
            return;
        }
        ListNode backNode = this.head;
        ListNode cur = backNode.next;
        while (cur != null) {
            if (cur.value == value) {
                backNode.next = cur.next;
                this.size--;
                return;
            }
            backNode = cur;
            cur = cur.next;
        }
    }
    //removeAll
    public void removeAll(int value) {
        if (this.size == 0) {
            return;
        }
        ListNode backNode = this.head;
        ListNode cur = backNode.next;
        while (cur != null) {
            if (cur.value == value) {
                backNode.next = cur.next;
                cur = cur.next;
                this.size--;
            } else {
                backNode = cur;
                cur = cur.next;
            }

        }
        if (this.head.value == value) {
            this.head = this.head.next;
            this.size--;
        }
    }
    //setByIndexForValue
    public void set(int index, int value) {
        if (index < 0 || index >= size) {
            return;
        }
        int count = 0;
        ListNode cur = this.head;
        while (count < index) {
            cur = cur.next;
            count++;
        }
        cur.value = value;
    }
    //toArray
    public int[] toArray() {
        if (this.size == 0) {
            return null;
        }
        ListNode cur = this.head;
        int[] ret = new int[this.size];
        int index = 0;
        while (cur != null) {
            ret[index] = cur.value;
            index++;
            cur = cur.next;
        }
        return ret;
    }
    //toString
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode cur = this.head;
        while (cur != null) {
            builder.append(cur.value);
            if (cur.next != null) {
                builder.append(",");
            }
            cur = cur.next;
        }
        return builder.toString();
    }

}
