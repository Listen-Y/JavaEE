class PCB {
    public String pcbName;
    public PCB next;
    public int time;
    public int priority;
    public char state = 'R';

    public PCB(String pcbName, int time, int priority) {
        this.pcbName = pcbName;
        this.time = time;
        this.priority = priority;
    }

}

public class ProcessScheduling {
    //头结点
    private PCB head;
    //pcb对象插入操作
    public void addPCB(PCB node) {
        //若头结点为空 首次插入的时候head的指向是空的
        if (this.head == null) {
            this.head = node;
            return;
        }
        //进行边插边按优先级进行排序

        //如果优先级比头结点大
        if (node.priority > this.head.priority) {
            node.next = this.head;
            this.head = node;
            return;
        }
        //如果和头结点优先级相同,按先来先服务原则
        if (node.priority == this.head.priority) {
            node.next = this.head.next;
            this.head.next = node;
            return;
        }
        //在node的优先级在中间插入 中间插入就需要找到合适的位置(按优先级判断)
        //tmp是临时的一个引用 将其直接指向头结点的下一个 方便后序优先级的判断
        PCB tmp = this.head.next;
        PCB parent = this.head;
        while (tmp != null) {
            if (node.priority > tmp.priority) {
                //进行插入
                node.next = parent.next;
                parent.next = node;
                return;
            } else if (node.priority == tmp.priority) {
                //优先级相同,按先来先服务原则
                parent = tmp;
                node.next = parent.next;
                parent.next = node;
                return;
            }
            parent = tmp;
            tmp = tmp.next;
        }
        //此时还未结束说明优先级最下就直接插到尾
        parent.next = node;
        node.next = null;
    }

    //进程运行方法
    public void runPCB() {
        while (this.head != null) {
            //运行优先级最高的第一个进程
            PCB cur = this.head;
            this.head = this.head.next;
            System.out.println();
            System.out.println("开始执行" + cur.pcbName + "进程");

            System.out.println("进程名:" + cur.pcbName +  "  要求运行时间:" + cur.time + "  优先级数:" + cur.priority
                    + "  状态:" + cur.state);
            //cur的运行优先级-1 运行时间-1
            cur.priority -= 1;
            cur.time -= 1;
            System.out.println(cur.pcbName + "进程执行完毕");
            System.out.println();
            //将cur再插入进程队列
            //如果所需运行时间为0,状态改为E
            if (cur.time == 0) {
                cur.state = 'E';
                System.out.println(cur.pcbName + "退出进程队列");
                System.out.println("进程名:" + cur.pcbName +  "  要求运行时间:" + cur.time + "  优先级数:" + cur.priority
                        + "  状态:" + cur.state);

                System.out.println();
            } else {
                //如果所需运行时间不为0,重新加到链表中
                addPCB(cur);
            }

            //运行一次结束后遍历显示此时进程队列所有信息
            if (this.head == null) {
                System.out.println("所有进程执行完毕");
                return;
            } else {
                System.out.println("此时进程队列的所有进程信息:");
                System.out.println("-------------------");
                displayAll();
                System.out.println("-------------------");
            }

        }
    }

    public void displayAll() {
        //for循环遍历此时链表中的说有pcb对象
        for (PCB pcb = this.head; pcb != null; pcb = pcb.next) {
            System.out.println("进程名:" + pcb.pcbName +  "  要求运行时间:" + pcb.time + "  优先级数:" + pcb.priority
                    + "  状态:" + pcb.state);
        }
    }

    public static void main(String[] args) {
        PCB[] pcbs = new PCB[5];
        pcbs[0] = new PCB("P1", 2, 1);
        pcbs[1] = new PCB("P2", 3, 5);
        pcbs[2] = new PCB("P3", 1, 3);
        pcbs[3] = new PCB("P4", 2, 4);
        pcbs[4] = new PCB("P5", 4, 2);
        ProcessScheduling processScheduling = new ProcessScheduling();

        //将上面构建好的5个pcb add进去
        for (int i = 0; i < pcbs.length; i++) {
            processScheduling.addPCB(pcbs[i]);
        }
        processScheduling.runPCB();
    }

}

