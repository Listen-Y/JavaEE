/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 15:30
 */
public class Demo4 {

    public static void main(String[] args) throws InterruptedException {
        Service4 service4 = new Service4();
        //创建3个A线程, 三个B线程
        Thread[] threadsA = new Thread[3];
        Thread[] threadsB = new Thread[3];

        for (int i = 0; i < 3; i++) {
            threadsA[i] = new Thread("A" + i) {
                @Override
                public void run() {
                    service4.awaitA();
                }
            };
            threadsB[i] = new Thread("B" + i) {
                @Override
                public void run() {
                    service4.awaitB();
                }
            };
        }

        for (int i = 0; i < 3; i++) {
            threadsA[i].start();
            threadsB[i].start();
        }
        Thread.sleep(100);

        System.out.println();
        System.out.println("signal一个A线程");
        service4.signalA();
        Thread.sleep(100);
        System.out.println();
        System.out.println("signal一个A一个B");
        service4.signalAandB();
        Thread.sleep(100);
        System.out.println();
        System.out.println("signalAll所有的B线程");
        service4.signalB_All();
        Thread.sleep(100);
        System.out.println();
        System.out.println("最后再signal一个A线程");
        service4.signalA();
    }
}
