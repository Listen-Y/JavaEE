import java.util.Arrays;
import java.util.Random;

public class DiskTest {

    public static void main(String[] args) throws InterruptedException {

        //需要在创建磁盘调度的时候说明此时磁头的位置和方向
        DiskScheduling diskScheduling = new DiskScheduling(100, "right");

        //生成15个随机数
        int[] nums = new int[15];
        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            nums[i] = random.nextInt(DiskScheduling.MaximumTrack);
        }

        System.out.println("初始申请序列:");
        System.out.println(Arrays.toString(nums));

        System.out.println("=========================");

        System.out.println("电梯调度执行顺序");
        diskScheduling.add(nums);

        System.out.println();
        //等线程执行完毕再去打印寻道
        diskScheduling.join();
        System.out.print("平均寻道为:");
        System.out.println(diskScheduling.averageSeekLength());
    }
}
