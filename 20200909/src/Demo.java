/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-09
 * Time: 17:44
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        MyThreadPool threadPool = new MyThreadPool();
        Integer[] integers = new Integer[] {1};
        for (int i = 0; i < 20; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("别打断..");
                    }
                    System.out.println(integers[0] + "正在执行");
                }
            });
            integers[0]++;
        }
        threadPool.shutDown();
    }
}
