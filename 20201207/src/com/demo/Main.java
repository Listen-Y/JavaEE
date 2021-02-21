package com.demo;

import java.util.*;

import static jdk.nashorn.internal.objects.Global.allocate;
import static jdk.nashorn.internal.objects.Global.print;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-07
 * Time: 21:34
 */
public class Main {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] strS = line.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String str : strS) {
                nums.add(Integer.parseInt(str));
            }
            Collections.sort(nums);
            int first = 0;
            Iterator<Integer> iterator = nums.iterator();
            while (iterator.hasNext()) {
                first = iterator.next();
                if (first != 0) {
                    iterator.remove();
                    break;
                }
            }
            StringBuilder buffer = new StringBuilder(String.valueOf(first));
            for (int n : nums
                 ) {
                buffer.append(n);
            }
            System.out.println(buffer.toString());
        }
    }

    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int ret = num * (num - 1) + 1;
            List<Integer> list = new ArrayList<>(num);
            while (num > 0) {
                list.add(ret);
                ret += 2;
                num--;
            }
            StringBuilder builder = new StringBuilder();
            for (int temp: list
                 ) {
                builder.append(temp).append("+");
            }
            System.out.println(builder.toString().substring(0, builder.length() - 1));
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            List<Integer> list = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                list.add(scanner.nextInt());
            }
            StringBuilder builder = new StringBuilder();
            for (int i = 1; i < 10; i++) {
                if(list.get(i) != 0) {
                    builder.append(i);
                    list.set(i, list.get(i) - 1);
                    break;
                }
            }
            for (int i = 0; i < 10; i++) {
                if (list.get(i) != 0) {
                    for (int j = 0; j < list.get(i); j++) {
                        builder.append(i);
                    }
                }
            }
            System.out.println(builder.toString());
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    public ArrayList<Integer> printMatrix2(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        add(matrix, 0, matrix[0].length - 1, list);
        return list;
    }

    private void add(int[][] matrix, int start, int end, ArrayList<Integer> list) {
        if (start > end || end < 0) {
            return;
        }
        for (int i = start; i <= end; i++) {
            list.add(matrix[start][i]);
        }
        for (int i = start + 1; i <= end; i++) {
            list.add(matrix[i][end]);
        }
        for (int i = end - 1; i >= start; i--) {
            list.add(matrix[end][i]);
        }
        for (int i = end - 1; i > start; i--) {
            list.add(matrix[i][start]);
        }
        add(matrix, start + 1, end - 1, list);
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null) {
            return list;
        }
        printf(matrix, 0, matrix.length - 1, matrix[0].length - 1, list);
        return list;
    }

    private void printf(int[][] matrix, int start, int dep, int with, ArrayList<Integer> list) {
        if (start > with || start > dep || dep < 0 || with < 0) {
            return;
        }
        for (int i = start; i <= with; i++) {
            list.add(matrix[start][i]);
        }
        for (int i = start + 1; i <= dep; i++) {
            list.add(matrix[i][with]);
        }
        for (int i = with - 1; i >= start && dep > start; i--) {
            list.add(matrix[dep][i]);
        }
        for (int i = dep - 1; i > start && with > start; i--) {
            list.add(matrix[i][start]);
        }
        printf(matrix, start + 1, dep - 1, with - 1, list);
    }

}
