import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-23
 * Time: 9:41
 */

import javax.activation.*;
public class Main {

    public static void main(String[] args) {



    }

    public static int MoreThanHalfNum_Solution(int [] array) {

        if (array == null) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array
             ) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()
             ) {
            if (entry.getValue() > array.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        int left;
        int right;
        for (left = 0; left < nums.length - 1; left++) {
            for (right = left + 1; right < nums.length; right++) {
                if (nums[left] + nums[right] == target) {
                    return new int[] {left, right};
                }
            }
        }
        return null;

    }

    public static int[] twoSum1(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.get(need) != null) {
                return new int[] {map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return null;

    }


}
