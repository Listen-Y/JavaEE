public class TestPool {

    public static void main(String[] args) throws InterruptedException {

        MyThreadPool pool = new MyThreadPool();

        for (int i = 0; i < 1000; i++) {
            pool.exculuct(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务执行中");
                }
            });

        }

        Thread.sleep(2000);
        pool.shutdown();


    }
}
