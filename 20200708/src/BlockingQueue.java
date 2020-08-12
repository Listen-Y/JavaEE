//实现阻塞队列
public class BlockingQueue {
    //存放数据
    private int[] array = new int[20];
    private int haed = 0;
    private int tail = 0;
    private volatile int size = 0;

    //put向队列放元素
    public void put(int val) throws InterruptedException {

        synchronized (this) {
            //队列满了就进入等待 直到有线程放数据去唤醒

            while (this.size == array.length) {
                this.wait();
            }

            array[tail] = val;
            tail++;
            size++;
            if (tail == array.length) {
                this.tail = 0;
            }

            this.notify();
        }
    }

    //take取队首元素
    public int take() throws InterruptedException {

        int ret;
        synchronized (this) {
            //如果队列为空 进入等待 知道有线程取元素取唤醒它
            while (this.size == 0) {
                this.wait();
            }

            ret = array[haed];
            haed++;
            size--;
            if (haed == array.length) {
                this.haed = 0;
            }

            this.notify();
        }

        return ret;
    }
}
