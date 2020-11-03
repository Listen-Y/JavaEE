import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 13:53
 */
public class MyTimer {

    private PriorityBlockingQueue<Task> priorityBlockingQueue = new PriorityBlockingQueue<>();
    private final Object lock = new Object();

    public MyTimer() {
        Worker worker = new Worker(priorityBlockingQueue, lock);
        worker.start();
    }

    public void schedule(Runnable runnable, long time) {

        Task task = new Task(runnable, time);
        priorityBlockingQueue.put(task);
        //如果现在有任务正在等待 而且新加进来的线程任务是优先级更高的所有要唤醒执行的那个线程去重写判断
        synchronized (lock) {
            lock.notify();
        }

    }

    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();

        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("haha");
                myTimer.schedule(this, 2000);
            }
        }, 2000);
    }

}

//首先需要一个Task任务类去表示一个任务
//comparable表示一个你可以去比较 是一个形容词, 重写的是comparaTo也就是to谁去比较
//comparacter是一个名词一样 比较, 就是拿俩个东西去比较 重写的是comarat
class Task implements Comparable<Task> {

    //一个runnable将要执行的任务
    //一个time表示什么时间后执行
    private Runnable runnable;
    public long time;

    public Task(Runnable runnable, long time) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + time;
    }

    public void run() {
        runnable.run();
    }

    @Override
    public int compareTo(Task o) {
        return (int) (this.time - o.time);
    }
}

//需要一个工作类去工作
class Worker extends Thread {

    //需要接受一个阻塞优先级队列
    //需要一把锁保证线程安全
    private PriorityBlockingQueue<Task> priorityBlockingQueue;
    private final Object lock;

    public Worker(PriorityBlockingQueue<Task> priorityBlockingQueue, Object lock) {
        this.priorityBlockingQueue = priorityBlockingQueue;
        this.lock = lock;
    }

    @Override
    public void run() {

        //循环扫描阻塞队列中的任务
            synchronized (lock) {
                while (true) {
                    try {
                        Task task = priorityBlockingQueue.take();
                        //获取当前时间
                        long now = System.currentTimeMillis();
                        if (task.time > now) {
                            //说明时间未到
                            lock.wait(task.time - now);
                            priorityBlockingQueue.put(task);
                        } else {
                            task.run();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
    }
}