import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-11
 * Time: 20:09
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        lists.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        lists.add(list2);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        lists.add(list3);
        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        lists.add(list4);
        System.out.println(solution.minimumTotal2(lists));
    }
}
