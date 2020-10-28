/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-05
 * Time: 14:14
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        ServiceResources resources = new ServiceResources();
        //创建一个生产者和多个消费者
        ThreadP threadP1 = new ThreadP(resources, "P1");
        ThreadC threadC1 = new ThreadC(resources, "C1");
        ThreadC threadC2 = new ThreadC(resources, "C2");
        ThreadC threadC3 = new ThreadC(resources, "C3");
        ThreadC threadC4 = new ThreadC(resources, "C4");
        ThreadC threadC5 = new ThreadC(resources, "C5");
        threadP1.start();
        threadC1.start();
        threadC2.start();
        threadC3.start();
        threadC4.start();
        threadC5.start();
        Thread.sleep(5000);
        //获得所有线程的状态
        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);
        for (int i = 0; i < threadArray.length; i++) {
            System.out.println(threadArray[i].getName() + " " + threadArray[i].getState());
        }
    }
}
