import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackKinds {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        //输出出栈的所有情况
        int[] nums = new int[] {1,2,3};
        for (int x : nums
             ) {
            stack1.push(x);
        }
        allKinds("");

        for (String s : list
             ) {
            System.out.println(s);
        }
    }

    private static void allKinds(String s) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            list.add(s.trim());
            return;
        }

        if (!stack2.isEmpty()) {
            String s1 = String.valueOf(stack2.pop());
            allKinds(s + " " + s1);
            //恢复
            stack2.push(Integer.parseInt(s1));
        }

        if (!stack1.isEmpty()) {
            String s1 = String.valueOf(stack1.pop());
            stack2.push(Integer.parseInt(s1));
            allKinds(s);
            //恢复
            stack2.pop();
            stack1.push(Integer.parseInt(s1));
        }
    }
}
