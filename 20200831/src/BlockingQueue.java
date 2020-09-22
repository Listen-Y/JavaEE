/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-31
 * Time: 10:42
 */
public class BlockingQueue {

    private int[] array;
    private int head;
    private int tail;
    private volatile int size;

    public BlockingQueue(int length) {
        this.array = new int[length];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    //offer
    public void offer(int value) throws InterruptedException {
        synchronized (this) {
            while (this.size == array.length) {
                this.wait();
            }
            this.array[this.tail] = value;
            this.tail++;
            this.size++;
            if (this.tail == this.array.length) {
                this.tail = 0;
            }
            this.notify();
        }
    }
    //poll
    public int poll() throws InterruptedException {
        synchronized (this) {
            while (this.size == 0) {
                this.wait();
            }
            int ret = this.array[this.head];
            this.head++;
            this.size--;
            if (this.head == this.array.length) {
                this.head = 0;
            }
            this.notify();
            return ret;
        }
    }
    //peek
    public Integer peek() {
        if (this.size == 0) {
            return null;
        }
        return this.array[this.head];
    }
    //size
    public int size() {
        return this.size;
    }
    //toString
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int index = this.head;
        for (int i = 0; i < this.size; i++) {
            index += i;
            if (index >= this.array.length) {
                index = 0;
            }
            builder.append(this.array[index]);
            builder.append(" ");
        }
        return builder.toString();
    }

}
