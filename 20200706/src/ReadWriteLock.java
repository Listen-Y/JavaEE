public class ReadWriteLock {
    //创建读锁和写锁
    private static final Object readWaitLock = new Object();

    //读写线程的个数
    private volatile int readCount = 0;
    private volatile int writeCount = 0;
    //操作的数据
    public  StringBuilder builder = new StringBuilder();

    //读操作
    public void read() throws InterruptedException {
        //读可以有多个但是不能和写操作共存
            //此处用while更好更安全 不然判断语句就只判断一次
            while (writeCount != 0) {
                //此时有写操作 所以进入等待
                synchronized (readWaitLock) {
                    readWaitLock.wait();
                }
            }

            //进行读操作 并将读操作计数器++
            readCount++;
            System.out.println("进程读操作:" + builder.toString());
            //读操作执行完毕
            readCount--;


        synchronized (readWaitLock) {
            readWaitLock.notify();
        }
    }

    //写操作
    public void write() throws InterruptedException {
        //写操作只能有一个 而且不能和读共存
        synchronized (readWaitLock) {
            //这里还是使用while循环
            while (writeCount != 0 && readCount != 0) {
                //只要有读操作和写操作存在就等待
                readWaitLock.wait();
            }

            //进行写操作 并将读操作计数器++
            writeCount++;
            System.out.println("写操作");
            builder.append("aaa");
            System.out.println("写执行完毕:" + builder.toString());
            //写操作执行完毕
            writeCount--;
        }
        synchronized (readWaitLock) {
            readWaitLock.notify();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        //创建多个读操作和写操作的线程
        ReadWriteLock readWriteLock = new ReadWriteLock();

        for (int i = 0; i < 10; i++) {

            //十个读线程
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        readWriteLock.read();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            //十个写线程
            Thread t1 = new Thread() {
                @Override
                public void run() {
                    try {
                        readWriteLock.write();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            t1.start();
            t.start();

        }

        //主线程休息会
        Thread.sleep(2000);
    }
}
