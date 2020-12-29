package com;

import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /*
    实现队列, 在尾部进入, 我将stack1作为数据的主要存储地方
     */
    public void push(int node) {

        //直接放到stack1的最后面即可
        stack1.push(node);
    }

    public int pop() {

        //将stack1中的第一个数据返回即可
        while (stack1.size() > 1) {
            int tmp = stack1.pop();
            stack2.push(tmp);
        }
        int ret = stack1.pop();
        //将数据放回到stack1中
        while (stack2.size() > 0) {
            int tmp = stack2.pop();
            stack1.push(tmp);
        }
        return ret;
    }

    public double Power(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent == 0) return 1;
        return Math.pow(base, exponent);
    }


    static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode one = head;
        ListNode two = head.next;
        ListNode three = two.next;
        one.next = null;
        while (three != null) {
            two.next = one;
            one = two;
            two = three;
            three = three.next;
        }
        two.next = one;
        return two;
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            } else if (list2.val < list1.val) {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            } else {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }
        if (list1 != null) {
            temp.next = list1;
        }
        if (list2 != null) {
            temp.next = list2;
        }
        return head.next;
    }

    static class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if (root1 == null || root2 == null) return false;

        return HasSubtreeHelper(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private boolean HasSubtreeHelper(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return true;
        if (root1 == null) return false;
        if (root2 == null) return true;
        return root1.val == root2.val && HasSubtreeHelper(root1.left, root2.left) && HasSubtreeHelper(root1.right, root2.right);
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("aaa");
        System.out.println(myStack.peek());

    }


}