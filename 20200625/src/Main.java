

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String need = scanner.nextLine();
            List<Character> strList = new ArrayList<>();
            List<Character> needList = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                strList.add(str.charAt(i));
            }
            for (int i = 0; i < need.length(); i++) {
                needList.add(need.charAt(i));
            }
            int count = 0;

            for (Character character : needList) {

                if (strList.contains(character)) {
                    strList.remove(character);
                    count++;
                }
            }

            if (count == needList.size()) {
                System.out.println("Yse " + strList.size());
            } else {
                System.out.println("No " + (needList.size() - count));
            }
        }
    }


    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode head = new ListNode(0);
        while (a != null && b != null) {
            addHead(a.val, b.val, head);
            a = a.next;
            b = b.next;
        }
        while (a != null) {
            addHead(a.val, 0, head);
            a = a.next;
        }
        while (b != null) {
            addHead(0, b.val, head);
            b = b.next;
        }
        if (key != 0) {
            addHead(0, 0, head);
        }
        return head.next;
    }

    private int key = 0;
    private void addHead(int val, int val1, ListNode head) {
        int num = 0;
        if (val + val1 + key >= 10) {
            num = (val + val1 + key) % 10;
            key = 1;
        } else {
            num = val + val1 + key;
            key = 0;
        }
        ListNode node = new ListNode(num);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }


    public static boolean isBalance(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.right) - height(root.left)) > 1) {
            return false;
        }
        if (!isBalance(root.right)) {
            return false;
        }
        if (!isBalance(root.left)) {
            return false;
        }
        return true;
    }

    private static int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }



    public static void main(String[] args) {
       /* System.out.println(Math.abs(-1));
        System.out.println(isBalance(null));*/
       int A4 = 8;
       int A4Count = 5;
      /*  double A4f = (A4 * 1.0) / A4Count;
        StringBuilder builder = new StringBuilder(String.valueOf(A4f));
        builder.delete(builder.indexOf(".") + 2, builder.length());
        System.out.println(builder.toString());*/
        BigDecimal decimal = new BigDecimal((A4 * 1.0) / A4Count);
        System.out.println(decimal.toString());
        decimal = decimal.setScale(1, BigDecimal.ROUND_HALF_UP);
        System.out.println(decimal.toString()
        );
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

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
