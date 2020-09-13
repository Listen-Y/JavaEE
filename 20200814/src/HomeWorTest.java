import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-14
 * Time: 12:00
 */
public class HomeWorTest {

    public static void main1(String[] args) {
      /*  int i = 2;
        int j = i++ * 3;
        System.out.println(j);*/


    }

    public boolean Find(int target, int [][] array) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (target > array[row][col]) {
                row++;
            } else if (target < array[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

    /*public void sortSpc(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int index = 0; index < array.length; index++) {

        }
    }*/

    public int JumpFloorII(int target) {
        if (target <= 1) {
            return target;
        }
        //左移一位表示 * 2
        return 1 << (target - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            int length = scan.nextInt();
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = scan.nextInt();
            }
            System.out.println(findResult(array));
        }
    }

    private static int findResult(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] = Math.max(array[i - 1] + array[i], array[i]);
            if (array[i] > ret) {
                ret = array[i];
            }
        }
        return ret;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //设置f(i) 但是要使长度加一 为了设置第一个初始态为true 方便后面以第i个元素之前的整体去判断是否在字典中存在
        Boolean[] booleans = new Boolean[s.length() + 1];
        booleans[0] = true;
        //累加字符去判断
        for (int i = 1; i <= s.length(); i++) {
            //j必须小于i 因为要通过j去找前面的那些已经判断了的哪个是true
            //j要>= 0 因为在下面中的s.sub中使用的是左闭右开 所以只有booleans[0]为true 并且j等于0才能得到我嗯想要的结果
            for (int j = i - 1; j >= 0; j--) {
                //使用转移方程
                if (booleans[j] && dict.contains(s.substring(j, i))) {
                    booleans[i] = true;
                    //找到可以了就结束j的循环
                    break;
                }
            }
        }
        return booleans[s.length()];
    }

    private static int findResult2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int ret = array[0];
        for (int i = 1; i < array.length; i++) {
            array[i] = Math.max(array[i - 1] + array[i], array[i]);
            if (array[i] > ret) {
                ret = array[i];
            }
        }
        return ret;
    }
}
