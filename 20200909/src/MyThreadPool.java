import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-09
 * Time: 17:21
 */
public class MyThreadPool {

    private BlockingQueue<Runnable> queue = new LinkedBlockingDeque<>();

    private static final int maxPoolNum = 10;

    private List<Worker> workers = new ArrayList<>();

    public void execute(Runnable runnable) throws InterruptedException {
        if (workers.size() < maxPoolNum) {
            Worker worker = new Worker(queue);
            worker.start();
            workers.add(worker);
        }
        //不要忘了将任务加到线程队列中
        queue.put(runnable);
    }

    public void shutDown() throws InterruptedException {
        for (Worker w : workers
             ) {
            w.interrupt();
        }
        //还得等待全部执行完才行
        for (Worker w : workers
             ) {
            w.join();

        }
    }

}

class Worker extends Thread {

    private BlockingQueue<Runnable> queue;

    public Worker(BlockingQueue<Runnable> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        try {
            while (!Thread.currentThread().isInterrupted()) {
                //注意用的是take
                Runnable runnable = queue.take();
                System.out.println("线程正在执行...");
                runnable.run();
            }
        } catch (InterruptedException e) {
            System.out.println("线程结束...");
        }

    }
}


