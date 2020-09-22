/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-31
 * Time: 15:41
 */
class ListNode {
    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }
}
public class MyStack {

    //把head当成栈尾 进在head出进 出也在head处出
    private ListNode head;

    //push
    public void push(int value) {
        ListNode node = new ListNode(value);
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.next = this.head;
        this.head = node;
    }
    //pop
    public Integer pop() {
        if (this.head == null) {
            return null;
        }
        int ret = this.head.value;
        this.head = this.head.next;
        return ret;
    }
    //peek
    public Integer peek() {
        if (this.head == null) {
            return null;
        }
        return this.head.value;
    }

}
