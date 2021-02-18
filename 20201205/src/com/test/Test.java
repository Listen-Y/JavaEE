package com.test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-05
 * Time: 11:20
 */
public class Test {

    public static void main(String[] args) {
        //构建三个person, 其中person和person2从表面看应该是相同的
        Person person = new Person("Listen", 22);
        Person person1 = new Person("bike", 21);
        Person person2 = new Person("Listen", 22);

        Map<Person, String> map = new HashMap<>();
        map.put(person, "第一名");
        map.put(person1, "第二名");
        //获取person2
        System.out.println(map.get(person2));
    }

    static class Person {
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    name.equals(((Person) o).name);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //球二叉树深度
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int depth = 0;

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        depth = 1;
        maxDepthHelper(root, depth);
        return depth;
    }

    public void maxDepthHelper(TreeNode root, int temp) {
        if (root == null) {
            return;
        }
        if (temp > depth) {
            depth = temp;
        }
        maxDepthHelper(root.left, temp + 1);
        maxDepthHelper(root.right, temp + 1);
    }
}

/**
 * select IFNULL((SELECT distinct Salary from Employee order by Salary desc limit 1, 1),NULL) as SecondHighestSalary
 * IFNULL可以有俩个参数, 如果第一个为null吗就可以设置默认值
 * limit有俩种用法, 第一 startIndex, pageSize, 第二 limit pageSize offset 跳过几个, 第二个效率高
 *
 * where>group by>having>order by sql语句的执行顺序
 * select email from person group by email having count(email) > 1;
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
