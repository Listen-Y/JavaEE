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

public class DiskScheduling {

    //需要一个链表去存储去存储要访问磁盘的线程
    //一个count记录访问次数
    //sum去记录访问距离
    //还需要一个磁头
    //还需要一个最大磁道是多少
    private List<Thread> threadList = new LinkedList<>();
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
            Thread t = new Thread(String.valueOf(track)) {
                @Override
                public void run() {
                    System.out.println(track + " ");
                }
            };
            threadList.add(t);
        }


        //将链表按要寻道的地址进行排序
        threadList.sort(new Comparator<Thread>() {
            @Override
            public int compare(Thread o1, Thread o2) {
                return Integer.parseInt(o1.getName()) - Integer.parseInt(o2.getName());
            }
        });

        worke();
    }

    //需要一个方法去执行程序
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
    }

    //需要一个方法返回平均寻道长度
    public float averageSeekLength () {

        return (float) ((this.sum * 1.0) / this.count);
    }
}
