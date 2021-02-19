package com.demo;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-06
 * Time: 12:40
 */
public class Test {

    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        for (int i = 0; i < astr.length() - 1; i++) {
            for (int j = i + 1; j < astr.length(); j++) {
                if (astr.charAt(i) == astr.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUnique2(String astr) {
        if (astr == null || astr.length() == 0) {
            return true;
        }
        for (int i = 0; i < astr.length() - 1; i++) {
            if (astr.indexOf(astr.charAt(i), i + 1) != -1) {
                return false;
            }
        }
        return true;
    }


    private String ret = "";

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        lengthOfLongestSubstringHelper(s, 0, "");
        System.out.println(ret);
        return ret.length();
    }

    private void lengthOfLongestSubstringHelper(String s, int index, String temp) {
        if (temp.length() > ret.length()) {
            ret = temp;
        }
        if (index >= s.length()) {
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (!temp.contains(String.valueOf(s.charAt(i)))) {
                temp = temp + s.charAt(i);
                lengthOfLongestSubstringHelper(s, i + 1, temp);
            } else {
                temp = temp.substring(temp.indexOf(s.charAt(i)) + 1);
                temp = temp + s.charAt(i);
                lengthOfLongestSubstringHelper(s, i + 1, temp);
            }
        }
    }

    public int lengthOfLongestSubstring(String s) {
        String ret = "";
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (temp.contains(String.valueOf(s.charAt(i)))) {
                temp = temp.substring(temp.indexOf(s.charAt(i)) + 1);
            }
            temp += s.charAt(i);
            if (temp.length() > ret.length()) {
                ret = temp;
            }
        }
        return ret.length();
    }

    static abstract class Person{

    }

}

class FooBar {
    private final int n;
    private boolean key = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(this) {
                // printFoo.run() outputs "foo". Do not change or remove this line.
                while(!key) {
                    this.wait();
                }
                printFoo.run();
                key = false;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            synchronized(this) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                while (key) {
                    this.wait();
                }
                printBar.run();
                key = true;
                this.notifyAll();
            }

        }
    }


    /**
     * select name as Customers from Customers where Id != (select CustomerId  from Orders;
     *
     * left join　是左连接，意思是左边的全保留，
     * 如果左边的和右边的不符合on的条件，那么左边对应右边的列自动为null
     */
}
