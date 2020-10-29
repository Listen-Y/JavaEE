/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 21:29
 */
public class JoinSleep {

    /*
    native关键字说明其修饰的方法是一个原生态方法，
    方法对应的实现不是在当前文件，而是在用其他语言（如C和C++）实现的文件中。
    Java语言本身不能对操作系统底层进行访问和操作，但是可以通过JNI接口调用其他语言来实现对底层的访问。

    public static native void sleep(long millis) throws InterruptedException;
     */


    /*
    public final synchronized void join(long millis)
    throws InterruptedException {
    //获取当前时间
        long base = System.currentTimeMillis();
        long now = 0;

        //判断等待时间是否合法 不合法抛出异常
        if (millis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (millis == 0) {
            //如果等于0判断当前线程是否存在, 如果存活就释放锁, 0秒后再去重新争取锁
            while (isAlive()) {
                wait(0);
            }
        } else {
            //如果等待时间大于0 判断当前线程是否存活
            while (isAlive()) {
            //获得要等待时间
                long delay = millis - now;
                if (delay <= 0) {
                //如果等待的时间小于0就结束
                    break;
                }
                //等还需要等待就释放锁,等delay秒后再去重新争取锁
                wait(delay);
                now = System.currentTimeMillis() - base;
            }
        }
    }
     */



    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread("A") {
            @Override
            public void run() {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                    this.wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.join(1000);
    }
}
