import java.util.*;
class Solution2 {
    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     *
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     *
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     *
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/open-the-lock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        //用一个hash去保存dead便于查找
        Set<String> deadSet = new HashSet<>();
        for (String str : deadends) {
            deadSet.add(str);
        }
        //如果0000是死亡数字那么永远有达不到
        if (deadSet.contains("0000")) {
            return -1;
        }
        //如果当前就是0000 就返回0
        if (target.equals("0000")) {
            return 0;
        }
        //用一个队列去保存此时的转盘上的数字
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        //计数器
        int step = 0;
        //用一个set保存访问过得密码
        Set<String> used = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String curStr = queue.poll();
                //进行一次的拨盘
                for (int i = 0; i < 4; i++) {
                    //一次波动有俩种可能
                    char newOne;
                    char newTwo;
                    //对curStr当前的字符是0/9要进行特殊处理
                    if (curStr.charAt(i) == '0' || curStr.charAt(i) == '9') {
                        if (curStr.charAt(i) == '0') {
                            newOne = '1';
                            newTwo = '9';
                        } else {
                            newOne = '0';
                            newTwo = '8';
                        }
                    } else {
                        newOne = (char) (curStr.charAt(i) + 1);
                        newTwo = (char) (curStr.charAt(i) - 1);
                    }
                    //将拨好的单个数字进行与其他三个字符想组合
                    StringBuilder oneBuilder = new StringBuilder(curStr);
                    StringBuilder twoBuilder = new StringBuilder(curStr);
                    oneBuilder.setCharAt(i, newOne);
                    twoBuilder.setCharAt(i, newTwo);
                    String oneStr = oneBuilder.toString();
                    String twoStr = twoBuilder.toString();
                    //对此时这俩个字符串进行判断
                    // 如果已经是target就返回操作步数
                    if (oneStr.equals(target) || twoStr.equals(target)) {
                        return step + 1;
                    }
                    //分别对俩个字符串进行判断是否为锁死密码和是否已经遍历过
                    if (!deadSet.contains(oneStr) && !used.contains(oneStr)) {
                        queue.offer(oneStr);
                        used.add(oneStr);
                    }
                    if (!deadSet.contains(twoStr) && !used.contains(twoStr)) {
                        queue.offer(twoStr);
                        used.add(twoStr);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}