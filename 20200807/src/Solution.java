import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-07
 * Time: 15:58
 */

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        int a = 1;
        int b = 2;
        int c = a + b;
        if (target == 1) {
            return a;
        }
        if (target == 2) {
            return b;
        }
        if (target == 3) {
            return c;
        }
        int count = 3;
        while (count < target) {
            a = b;
            b = c;
            c = a + b;
            count++;
        }
        return c;
    }

    public static void reOrderArray(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (right > left) {
            while (right > left && array[left] % 2 != 0) {
                left++;
            }
            while (right > left && array[right] % 2 == 0) {
                right--;
            }
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,6,7,8,9};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    public void reOrderArray1(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                int j = i + 1;
                while (j < array.length && j % 2 == 0) {
                    j++;
                }
                if (j < array.length) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public void reOrderArray2(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1) == 1) {
                int tmp = array[i];
                int j = i;
                while (j > index) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[index] = tmp;
                index++;
            }
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k < 0) {
            return null;
        }
        ListNode prev = head;
        ListNode later = head;
        while (k > 0 && prev != null) {
            k--;
            prev = prev.next;
        }
        while (prev != null) {
            prev = prev.next;
            later = later.next;
        }
        return k > 0 ? null : later;
    }
}