import java.util.concurrent.PriorityBlockingQueue;

public class Timer {

    private PriorityBlockingQueue<Task> blockingQueue = new PriorityBlockingQueue<>();
    private  final Object loker = new Object();

    public Timer() {
        Woker woker = new Woker(this.blockingQueue, this.loker);
        woker.start();
    }

    public void shedule(Runnable runnable, long after) {

        Task task = new Task(runnable, after);
        blockingQueue.put(task);

        synchronized (loker) {
            loker.notify();
        }
    }
}

//需要一个类去描述一个任务和设定执行的时间 要借助阻塞优先级队列完成所有需要指定大小
class Task implements Comparable<Task> {

    private Runnable runnable;
    private long time;

    public Task(Runnable runnable, long after) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + after;
    }


    public void run() {
        runnable.run();
    }

    public long getTime() {
        return this.time;
    }

    @Override
    public int compareTo(Task o) {
        return (int) (this.time - o.time);
    }
}

//还需要一个工作类去循环扫描执行任务
class Woker extends Thread {

    //接收传过来的优先级队列
    private PriorityBlockingQueue<Task> blockingQueue;
    private final Object loker;

    public Woker(PriorityBlockingQueue<Task> blockingQueue, Object loker) {
        this.blockingQueue = blockingQueue;
        this.loker = loker;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Task task = blockingQueue.take();
                long nowTime = System.currentTimeMillis();
                if (task.getTime() > nowTime) {
                    blockingQueue.put(task);
                    synchronized (loker) {
                        loker.wait(task.getTime() - nowTime);
                    }
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