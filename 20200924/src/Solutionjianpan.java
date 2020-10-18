import java.util.*;
class Solution {

    //需要一个map去初始化键盘数据
    private Map<Integer, String> info;

    public List<String> letterCombinations(String digits) {

        List<String> ret = new ArrayList<>();
        if (digits.length() == 0) {
            return ret;
        }
        //初始化键盘
        info = new HashMap<>();
        info.put(2, "abc");
        info.put(3, "def");
        info.put(4, "ghi");
        info.put(5, "jkl");
        info.put(6, "mno");
        info.put(7, "pqrs");
        info.put(8, "tuv");
        info.put(9, "wxyz");
        //使用深度优先加回溯思想完成
        DFS(digits, ret, "", 0);
        return ret;
    }

    private void DFS(String digits, List<String> ret, String curStr, int curLength) {
        //如果当前的字符串与输入数字的长度相同 说明一个组合完成
        if (curLength == digits.length()) {
            ret.add(curStr);
            return;
        }
        //获取当前的键盘数字输入
        int num = digits.charAt(curLength) - '0';
        String chars = info.get(num);
        for (int i = 0; i < chars.length(); i++) {
            curStr += chars.charAt(i);
            DFS(digits, ret, curStr, curLength + 1);
            //回溯
            curStr = curStr.substring(0, curStr.length() - 1);
        }
    }
}