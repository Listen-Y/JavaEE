import java.util.Arrays;
import java.util.Random;

public class TestDisk {

    public static void main(String[] args) {

        //需要在创建磁盘调度的时候说明此时磁头的位置和方向
        DiskScheduling diskScheduling = new DiskScheduling(100, "right");

        //生成15个随机数
        int[] nums = new int[15];
        for (int i = 0; i < 15; i++) {
            Random random = new Random();
            nums[i] = random.nextInt(DiskScheduling.MaximumTrack);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println("=========================");

        try {
            diskScheduling.add(nums);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(diskScheduling.averageSeekLength());
    }
}
