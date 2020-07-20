import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//这是一个磁头里面描述此时他在哪个下标 并且是往左方向走还是右方向
class Head {
    public int index;
    public String direction;

    public Head(int index, String direction) {
        this.index = index;
        this.direction = direction;
    }
}

//这是描述一个访问磁道任务的一个类
class MyRunnable implements Runnable {

    //要访问的磁道
    public int track;
    public boolean key = true;

    public MyRunnable(int track) {
        this.track = track;
    }

    @Override
    public void run() {
        System.out.print(track + " ");
    }
}

public class DiskScheduling extends Thread {

    //需要一个链表去存储去存储要访问磁盘的线程
    //一个count记录访问次数
    //sum去记录访问距离
    //还需要一个磁头
    //还需要一个最大磁道是多少
    private List<MyRunnable> threadList = new LinkedList<>();
    private int count;
    private int sum;
    private Head head;
    public static final int MaximumTrack = 200;

    //在构造函数里初始化磁头
    public DiskScheduling(int index, String direction) {
        this.head = new Head(index, direction);
    }

    //需要一个方法往链表为添加程序
    public void add(int[] tracks) throws InterruptedException {

        //创建线程 线程的名字就是他有寻找的磁道地址

        for (int track : tracks
             ) {
            MyRunnable myRunnable = new MyRunnable(track);
            threadList.add(myRunnable);
        }


        //将链表按要寻道的地址进行排序
       threadList.sort(new Comparator<MyRunnable>() {
           @Override
           public int compare(MyRunnable o1, MyRunnable o2) {
               return o1.track - o2.track;
           }
       });

        this.start();
        this.join();
        //worke();
    }

    @Override
    public void run() {

        while (this.count != threadList.size()) {
            while (this.head.direction.equals("right")) {

                for (MyRunnable m : threadList
                        ) {
                    if (m.track >= head.index && m.key) {
                        count++;
                        int distance = m.track - this.head.index;
                        sum += distance;
                        this.head.index = m.track;
                        m.key = false;
                        m.run();
                        //threadList.remove(m);
                    }
                    this.head.direction = "left";
                }

            }


            while (this.head.direction.equals("left")) {

                for (int i = threadList.size() - 1; i >= 0; i--) {

                    if (threadList.get(i).track > this.head.index || !threadList.get(i).key) {
                        continue;
                    }

                    //此时表示找到了比现在下标小的
                    this.count++;
                    int distance = this.head.index - threadList.get(i).track;
                    sum += distance;
                    this.head.index = threadList.get(i).track;
                    threadList.get(i).key = false;
                    this.threadList.get(i).run();
                    //this.threadList.remove(this.threadList.get(i));
                }

                this.head.direction = "right";
            }
        }
    }

    /* //需要一个方法去执行程序
    private void worke() throws InterruptedException {

        while (! this.threadList.isEmpty()) {

            while (this.head.direction.equals("right")) {
                synchronized (this) {
                    for (Thread t : this.threadList
                    ) {
                        if (Integer.parseInt(t.getName()) > this.head.index) {
                            this.count++;
                            int distance = Integer.parseInt(t.getName()) - this.head.index;
                            sum += distance;
                            this.head.index = Integer.parseInt(t.getName());
                            t.start();
                            t.join();
                            this.threadList.remove(t);
                        }
                    }
                }
                this.head.direction = "left";
            }

            while (this.head.direction.equals("left")) {
                synchronized (this) {
                    for (int i = this.threadList.size() - 1; i >= 0; i--) {
                        if (Integer.parseInt(this.threadList.get(i).getName()) > this.head.index) {
                            continue;
                        }

                        //此时表示找到了比现在下标小的
                        this.count++;
                        int distance = this.head.index - Integer.parseInt(this.threadList.get(i).getName());
                        sum += distance;
                        this.head.index = Integer.parseInt(this.threadList.get(i).getName());
                        this.threadList.get(i).start();
                        this.threadList.get(i).join();
                        this.threadList.remove(this.threadList.get(i));
                    }
                }
                this.head.direction = "right";
            }

        }
    }*/

    //需要一个方法返回平均寻道长度
    public float averageSeekLength () {

        return (float) ((this.sum * 1.0) / this.count);
    }
}



