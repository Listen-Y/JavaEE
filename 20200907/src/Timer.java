import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 实现一个定时器
 * User: Listen-Y.
 * Date: 2020-09-07
 * Time: 12:10
 */
public class Timer {

    //一个优先级阻塞队列
    private PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();
    //用于减少消耗的一把锁
    private final Object lock = new Object();

    public Timer() {
        //创建任务去执行定时任务
        Worker worker = new Worker(priorityBlockingQueue, lock);
        worker.start();

    }

    //给定时器中加任务
    public void schedule(Runnable runnable, long time) {
        Task task = new Task(runnable, time);
        priorityBlockingQueue.put(task);

        //以防万一我们新加进来的任务的优先级是最高的 而此时我们的扫描线程处于wait状态
        //所以我们在这里将扫描线程唤醒让他进行进一步的判断
        synchronized (lock) {
            lock.notify();
        }
    }

}

//定时任务
//因为其要加到优先级队列中 所以要实现comparable接口
class Task implements Comparable<Task> {

    private Runnable runnable;
    private long time;

    public Task(Runnable runnable, long time) {
        this.runnable = runnable;
        //定时任务 所以设置的执行时间是此时的时间加上等待的时间
        this.time = System.currentTimeMillis() + time;
    }

    //启动任务
    public void start() {
        this.runnable.run();
    }

    //获取其定的时间
    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(Task o) {
        //让时间小的下去执行
        return (int) (this.time = o.getTime());
    }
}

//执行任务
class Worker extends Thread {

    //需要获取定时器传开的优先级队列
    private PriorityBlockingQueue<Task> priorityBlockingQueue;
    //需要获取减少消耗的那把锁
    private final Object lock;

    public Worker(PriorityBlockingQueue<Task> priorityBlockingQueue, Object lock) {
        this.priorityBlockingQueue = priorityBlockingQueue;
        this.lock = lock;
    }

    //执行任务
    @Override
    public void run() {

        //这是一个扫描线程 扫描优先级队列中的任务
        while (true) {
            try {
                Task task = priorityBlockingQueue.take();
                long now = System.currentTimeMillis();
                if (task.getTime() > now) {
                    //定时还未到执行时间
                    priorityBlockingQueue.put(task);
                    //为了减小循环扫描的消耗直接让线程等待一些时间
                    synchronized (lock) {
                        lock.wait(task.getTime() - now);
                    }
                } else {
                    //执行时间到了
                    task.start();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
