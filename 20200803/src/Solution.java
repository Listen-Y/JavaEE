import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-03
 * Time: 10:24
 */
public class Solution {

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if (input == null) {
            return null;
        }
        int length = input.length;
        if (k == 0 || k > length) {
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] input = new int[] {4,5,1,6,2,7,3,8};
        //System.out.println(GetLeastNumbers_Solution(input, 4));
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.getTopK(input, 4));
    }

}


 class Solution1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
        for (int value : input) {
            if (maxHeap.size() != k) {
                maxHeap.offer(value);
            } else if (maxHeap.peek() > value) {
                maxHeap.offer(value);
            }
        }
        result.addAll(maxHeap);
        return result;
    }

    public ArrayList<Integer> getTopK(int[] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k == 0 || k > input.length) {
            return list;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : input
             ) {
            priorityQueue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            list.add(priorityQueue.poll());
        }
        return list;

    }
}
