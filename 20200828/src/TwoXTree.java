import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-31
 * Time: 20:18
 */
class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }
}
public class TwoXTree {

    public TreeNode make() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(1);
        TreeNode a3 = new TreeNode(1);
        TreeNode a4 = new TreeNode(1);
        TreeNode a5 = new TreeNode(1);
        TreeNode a6 = new TreeNode(1);
        TreeNode a7 = new TreeNode(1);
        a1.left = a2;
        a1.right = a3;
        a2.left = a4;
        a2.right = a5;
        a3.left = a6;
        a3.right = a7;
        return a1;
    }
    //先序
    public void prev(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        prev(root.left);
        prev(root.right);
    }
    //中序
    public void mid(TreeNode root) {
        if (root == null) {
            return;
        }
        mid(root.left);
        System.out.println(root);
        mid(root.right);
    }
    //后序
    public void back(TreeNode root) {
        if (root == null) {
            return;
        }
        back(root.left);
        back(root.right);
        System.out.println(root);
    }
    //层序
    public void levelOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.println(cur.value);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    //非递归先序
    public void prevByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            System.out.println(cur.value);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }
    //非递归中序
    public void midByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.empty()) {
                break;
            }
            TreeNode tmp = stack.pop();
            System.out.println(tmp.value);
            cur = tmp.right;
        }
    }
    //非递归后序
    public void backByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            TreeNode tmp = stack.peek();
            if (tmp.right == null || tmp.right == prev) {
                System.out.println(tmp);
                stack.pop();
                prev = tmp;
            } else {
                cur = tmp.right;
            }
        }
    }
}
