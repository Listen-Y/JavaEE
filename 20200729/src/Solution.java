/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-29
 * Time: 9:02
 */


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class Solution {

    private int index;
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        index = 0;
        return reConstructBinaryTreeHealper(pre, in, 0, pre.length);
    }

    private TreeNode reConstructBinaryTreeHealper(int [] pre,int [] in, int left, int right) {
        if (left >= right) {
            return null;
        }
        if (index >= pre.length) {
            return null;
        }
        TreeNode node = new TreeNode(pre[index]);
        index++;
        int pos = findpos(in, node.val);
        node.left = reConstructBinaryTreeHealper(pre, in, left, pos);
        node.right = reConstructBinaryTreeHealper(pre, in, pos + 1, right);
        return node;
    }

    private int findpos(int[] in, int val) {
        for (int i = 0; i < in.length; i++) {
            if (in[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public int minNumberInRotateArray1(int [] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (array[left] >= array[right]) {

            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) >> 1;
            if (array[left] == array[right] && array[mid] == array[left]) {
                int result = array[left];
                for (int i = left +1; i < right; i++) {
                    if (array[i] > result) {
                        result = array[i];
                    }
                }
                return result;
            }
            if (array[mid] >= array[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];
    }
}


