import java.util.Scanner;

/**
 * 优化银行家算法,实现资源再次申请
 */

//系统资源的数据结构
class Resources {
    public String name;
    public int num;

    public Resources(String name, int num) {
        this.name = name;
        this.num = num;
    }

    @Override
    public String toString() {
        return "资源"+ name  + "有" + num;
    }
}
//进程的数据结构
class PCB {
    public String name;
    public Resources[] max;//最大需求资源Max
    public Resources[] allocation;//已分配资源Allocation
    public Resources[] need;//需求资源Need
    public boolean finish = false;//表示进程是否获得足够资源

    public PCB(String name, Resources[] max, Resources[] allocation) {
        this.name = name;
        this.max = max;
        this.allocation = allocation;
        this.need = new Resources[max.length];
        for (int i = 0; i < need.length; i++) {
            this.need[i] = new Resources(max[i].name, max[i].num - allocation[i].num);
        }
    }

    @Override
    public String toString() {
        return this.name +(this.finish ? "进程已得到足够资源" : "需要等待");
    }
}

public class BetterBankerAlgorithm {
    private Resources[] work;//当前可以资源
    private PCB[] pcbs;//所有进程

    public BetterBankerAlgorithm(Resources[] Available, PCB[] pcbs) {
        this.work = Available;//一开始可用资源与系统总资源是相同的
        this.pcbs = pcbs;
        //计算剩余可用资源
        actualWork();
    }

    private void actualWork() {
        for (int i = 0; i < this.work.length; i++) {
            //初始系统总资源减去已分配的资源就是当前可以利用的资源
            this.work[i].num = this.work[i].num - pcbsAllRes(i);
        }
    }
    //计算所有进程已分配的第i个资源总数
    private int pcbsAllRes(int index) {
        int sum = 0;
        for ( PCB p : pcbs
        ) {
            sum += p.allocation[index].num;
        }
        return sum;
    }

    //判断是否为安全状态
    private boolean ifSafe() {
        for (PCB p : pcbs
        ) {
            if (! p.finish) {
                return false;
            }
        }
        return true;
    }

    //进行资源分配
    public void resAllocation() {
        //对进程进行循环资源分配,当所有进程都需要等待或者所有进程都为安全状态退出循环
        for (int i = 0; !ifSafe() && !ifAllNeedWait(); i++) {
            //实现循环
            if (i == this.pcbs.length) {
                i = 0;
            }
            //判断当前这个进程是否已经获得过足够资源
            if (pcbs[i].finish) {
                continue;
            }
            //判断当前这个进程是否需要等待
            if (! needWait(pcbs[i])) {
                //进行资源分配
                mainOperation(pcbs[i]);
                System.out.println(pcbs[i]);
                System.out.println();
                displayWorks();
            }
        }
        System.out.println();
        if (ifSafe()) {
            System.out.println("系统处于安全状态");
        } else {
            System.out.println("系统处于不安全状态");
        }
    }

    private void displayWorks() {
        System.out.println("此时系统可用资源为:");
        System.out.println("====================");
        for (Resources r : this.work
        ) {
            System.out.println(r);
        }
        System.out.println("====================");
    }

    private boolean ifAllNeedWait() {
        for (PCB p : this.pcbs
        ) {
            //如果该进程已经得到过足够资源就不进行判断
            if (!p.finish) {
                //如果该进程不需要等待就直接返回false
                if (!needWait(p)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void mainOperation(PCB pcb) {
        //运行到这说明该进程可以得到足够的资源,那么直接将该进程已分配的资源放回到系统中
        //并将finish改为true
        for (int i = 0; i < this.work.length; i++) {
            this.work[i].num += pcb.allocation[i].num;
            pcb.finish = true;
        }
    }

    private boolean needWait(PCB pcb) {
        //挨个判断此时pcb这个进程所需要的每个资源,如果need大于系统当前可分配资源,就说明需要等待
        for (int i = 0; i < this.work.length; i++) {
            if (this.work[i].num < pcb.need[i].num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("输入资源有几种:");
        int resKindNum = scan.nextInt();
        Resources[] Available = new Resources[resKindNum];//系统总资源
        System.out.println();
        System.out.println("输入每个系统资源名称、系统资源数量");


        for (int i = 0; i < Available.length; i++) {
            System.out.println("初始化第" + (i +1) + "个资源");
            System.out.println();
            System.out.print("资源名称:");
            String name = scan.next();
            System.out.println();
            System.out.print("该资源数量:");
            int num = scan.nextInt();
            Available[i] = new Resources(name, num);
            System.out.println();
            System.out.println("第" + (i +1) + "个资源初始化完毕");
            System.out.println("====================");
        }


        System.out.println();
        System.out.println("系统资源初始化完毕,开始初始化进程");
        System.out.println();


        System.out.print("输入进程个数:");
        int pcbNums = scan.nextInt();
        PCB[] pcbs = new PCB[pcbNums];


        for (int i = 0; i < pcbNums; i++) {
            System.out.println("初始化第" + (i +1) + "个进程");
            System.out.println();
            System.out.print("输入进程名:");
            String name = scan.next();
            System.out.println();
            System.out.print("输入该进程最大需求资源:");
            Resources[] max = new Resources[resKindNum];
            int[] maxResNum = new int[resKindNum];
            for (int j = 0; j < resKindNum; j++) {
                maxResNum[j] = scan.nextInt();
            }


            for (int j = 0; j < max.length; j++) {

                max[j] = new Resources(Available[j].name, maxResNum[j]);
            }


            System.out.println();
            System.out.print("输入该进程已分配资源数目:");
            Resources[] allocation = new Resources[resKindNum];
            int[] allocReesNum = new int[resKindNum];
            for (int j = 0; j < resKindNum; j++) {
                allocReesNum[j] = scan.nextInt();
            }

            for (int j = 0; j < allocation.length; j++) {
                allocation[j] = new Resources(Available[j].name, allocReesNum[j]);
            }
            System.out.println();


            //此时一个进程的所有需要的东西都已输入完毕
            pcbs[i] = new PCB(name, max, allocation);
            System.out.println("第" + (i +1) + "个进程初始化完毕");
            System.out.println("====================");
        }

        System.out.println();
        System.out.println("========所有进程初始化完毕,开始资源分配========");
        System.out.println();

        boolean key = true;
        while (key) {
            BetterBankerAlgorithm bankerAlgorithm = new BetterBankerAlgorithm(Available, pcbs);
            bankerAlgorithm.resAllocation();
            System.out.println();
            System.out.println("是否需要再次申请资源输入: y or n ");
            char ch = scan.next().charAt(0);
            if (ch == 'n' || ch == 'N') {
                key = false;
            } else {
                System.out.print("输入要申请资源的进程名:");
                String name = scan.next();
                System.out.println();
                System.out.print("输入要申请资源的数量:");
                int[] res = new int[resKindNum];
                for (int i = 0; i < resKindNum; i++) {
                    res[i] = scan.nextInt();
                }
                System.out.println();


                for (PCB p : pcbs
                ) {
                    p.finish = false;
                    if (p.name.equals(name)) {
                        for (int i = 0; i < p.allocation.length; i++) {
                            p.allocation[i].num += res[i];
                        }
                    }
                }
                System.out.println();
                System.out.println("========再次申请资源完毕,开始资源分配========");
                System.out.println();
            }
        }
    }
}

