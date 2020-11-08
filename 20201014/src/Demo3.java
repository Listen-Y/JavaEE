import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-14
 * Time: 18:02
 */
public class Demo3 {

    public static void main(String[] args) throws InterruptedException {
        //初始化semaphore
        Service service = new Service(10);
        //创建线程池让线程池去消耗semaphore资源
        ExecutorService pool = Executors.newFixedThreadPool(Service.MAx_THREAD);

        for (int i = 0; i < Service.MAx_THREAD; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        service.getSemaphore().acquire();
                        System.out.println("use data");
                        System.out.println(new Date().toString());
                        Thread.sleep(5000);
                        service.getSemaphore().release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(1000);
        pool.shutdown();


    }
}

class Service {

    public static final int MAx_THREAD = 30;
    private Semaphore semaphore;

    public Service(int num) {
        this.semaphore = new Semaphore(num);
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }
}
