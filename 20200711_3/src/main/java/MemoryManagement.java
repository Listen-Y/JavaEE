import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//因为要释放作业时 这个作业必须已经是申请过的不然会抛出一个异常
class HomeWorkNotFindException extends Exception {

    public HomeWorkNotFindException(String message) {
        super(message);
    }
}

//还需要一个异常表示 内存放不下
class MemoryFullException extends Exception {
    public MemoryFullException(String message) {
        super(message);
    }
}


//作业类 有一个id和要申请或者的内存大小 和要执行什么操作
class HomeWork {

    public int id;
    public int need;
    public String doing;

    public HomeWork(int id, int need, String doing) {
        this.id = id;
        this.need = need;
        this.doing = doing;
    }
}

//区域类 表示内存的起始地址和大小和状态
class Area {

    public int homeWorkId;
    public int indexBig;
    public int areaSize;
    public boolean state;

    public Area(int homeWorkId, int indexBig, int areaSize, boolean state) {
        this.homeWorkId = homeWorkId;
        this.indexBig = indexBig;
        this.areaSize = areaSize;
        this.state = state;//true表示未分配 false表示已分配
    }

    @Override
    public String toString() {
        return indexBig + "k" + "  " + areaSize + "k" + "  " + (state ? "未分配" : "已分配");
    }
}

public class MemoryManagement {

    private List<Area> list = new LinkedList<>();

    public MemoryManagement() {
        list.add(new Area(0, 0, 512, true));
    }

    //只需要把作业传进来 在这个类里会判断是要申请空间还是释放空间
    public void implementWork(HomeWork homeWork) throws HomeWorkNotFindException, MemoryFullException {

        if ("申请".equals(homeWork.doing)) {
            apply(homeWork);
            displayFreeArea();
        } else {
            if ("释放".equals(homeWork.doing)) {
                free(homeWork);
                displayFreeArea();
            }
        }

    }

    private void free(HomeWork homeWork) throws HomeWorkNotFindException {
        for (Area a: this.list
        ) {
            if (a.homeWorkId == homeWork.id) {
                a.state = true;
                for (int index = list.indexOf(a) - 1; index >= 0 && list.get(index).state; index--) {
                    Area area = list.get(index);
                    area.areaSize += a.areaSize;
                    list.remove(a);
                    a = area;
                }

                for (int index = list.indexOf(a) + 1; index < list.size() && list.get(index).state; index++) {
                    Area area = list.get(index);
                    a.areaSize += area.areaSize;
                    list.remove(area);
                }
                return;
            }
        }

        //抛出一个异常
        throw new HomeWorkNotFindException("未找到要释放的内存区域");
    }

    private void apply(HomeWork homeWork) throws MemoryFullException {
        for (Area a : this.list
        ) {
            if (a.state && a.areaSize >= homeWork.need) {
                //找到那个我们需要的区域
                if (a.areaSize == homeWork.need) {
                    //空闲区域和需要的区域大小相等
                    a.homeWorkId = homeWork.id;
                    a.state = false;
                } else {
                    Area areaTrue = new Area(homeWork.id, a.indexBig, homeWork.need, false);
                    Area areaFalse = new Area(homeWork.id, a.indexBig + homeWork.need, a.areaSize - homeWork.need, true);
                    list.remove(a);
                    list.add(areaTrue);
                    list.add(areaFalse);
                }

                this.list.sort(new Comparator<Area>() {
                    @Override
                    public int compare(Area o1, Area o2) {
                        return o1.indexBig - o2.indexBig;
                    }
                });

                return;
            }
        }

        //如果最后一个空闲区域内存还是不够大
        throw new  MemoryFullException("内存放不下");
    }

    //打印空闲区域
    public void displayFreeArea() {

        System.out.println("======================");
        System.out.println("起址" + "  " + "长度" + "  " + "状态");
        for (Area a : this.list
        ) {
            if (a.state) {
                System.out.println(a.toString());
            }
        }
        System.out.println("======================");
    }

    public static void main(String[] args) {

        MemoryManagement memoryManagement = new MemoryManagement();

        //创建作业
        HomeWork[] homeWorks = new HomeWork[8];
        homeWorks[0] = new HomeWork(1, 300, "申请");
        homeWorks[1] = new HomeWork(2, 100, "申请");
        homeWorks[2] = new HomeWork(1, 300, "释放");
        homeWorks[3] = new HomeWork(3, 150, "申请");
        homeWorks[4] = new HomeWork(4, 30, "申请");
        homeWorks[5] = new HomeWork(5, 40, "申请");
        homeWorks[6] = new HomeWork(6, 60, "申请");
        homeWorks[7] = new HomeWork(4, 30, "释放");

        //
        System.out.println("初始空闲说明表");
        memoryManagement.displayFreeArea();

        //执行作业
        for (HomeWork h : homeWorks
        ) {

            System.out.println();
            System.out.println();
            System.out.println("执行作业" + h.id + "任务是" + h.doing + h.need + "k");
            try {
                memoryManagement.implementWork(h);
            } catch (HomeWorkNotFindException | MemoryFullException e) {
                e.printStackTrace();
            }
            System.out.println("此时空闲列表如下:");
        }
    }

}

