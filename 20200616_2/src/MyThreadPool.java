import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class MyThreadPool {

    private BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>();
    private List<Worke> wokeList = new LinkedList<>();
    private static final int MaxThreadCount = 10;

    public void exculuct(Runnable runnable) throws InterruptedException {

        if (this.wokeList.size() < MaxThreadCount) {
            Worke worke = new Worke(blockingQueue);
            wokeList.add(worke);
            worke.start();
        }

        blockingQueue.put(runnable);
    }

    public void shutdown() throws InterruptedException {

        for (Worke w : wokeList
             ) {
            w.interrupt();
        }

        for (Worke w: wokeList
             ) {
            w.join();
        }

        System.out.println("线程全部被打断");
    }
}

class Worke extends Thread{

    private BlockingQueue<Runnable> blockingQueue;

    public Worke(BlockingQueue<Runnable> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {

            while (! Thread.currentThread().isInterrupted()) {
                Runnable runnable = blockingQueue.take();
                runnable.run();
            }
        } catch (InterruptedException e) {
            System.out.println("该线程被打断");
        }
    }
}
