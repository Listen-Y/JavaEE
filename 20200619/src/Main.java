
import java.util.*;

//队列的所有情况打印
public class Main {

    private static Stack<String> stack1 = new Stack<>();
    private static Stack<String> stack2 = new Stack<>();
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            for (int i = strings.length - 1; i >= 0; i--) {
                stack1.push(strings[i]);
            }

            list.clear();
            tranOut("");

            Collections.sort(list);

            for (String str : list
                 ) {
                System.out.println(str);
            }
        }
    }

    private static void tranOut(String str) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            list.add(str.trim());
            return;
        }

        if (!stack2.isEmpty()) {
            String str1 = stack2.pop();
            tranOut(str + " " + str1);
            //恢复
            stack2.push(str1);
        }

        if (!stack1.isEmpty()) {
            String str1 = stack1.pop();
            stack2.push(str1);
            tranOut(str);
            //恢复
            stack2.pop();
            stack1.push(str1);
        }
    }


    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}