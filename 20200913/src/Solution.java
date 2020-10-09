/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-13
 * Time: 10:57
 */
public class Solution {

//回文串分割(Palindrome Partitioning)
    public int minCut(String s) {

        if (s == null) return 0;
        if (s.length() == 0) return 0;

        //设置一个一维数组保存f[i]
        int[] f = new int[s.length() + 1];
        for (int i = 0; i < f.length; i++) {
            //初始化f[i]等于当前字符串最大分割次数
            f[i] = i - 1;
        }
        //index表示index下标前的字符串
        for (int index = 1; index <= s.length(); index++) {
            //i表示模拟分割的地方 为了方便看整体 i应该模拟分割从0开始
            for (int i = 0; i < index; i++) {
                if (isHuiWen(s, i, index - 1)) {
                    f[index] = Math.min(f[index], f[i] + 1);
                }
            }
        }
        return f[s.length()];
    }

    private boolean isHuiWen(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

//编辑距离(Edit Distance)
    public int minDistance(String word1, String word2) {
        
        if (word1 == null && word2 == null) return 0;
        if (word1 == null || word1.length() == 0) {
            return word2.length();
        }
        if (word2 == null || word2.length() == 0) {
            return word1.length();
        }
        
        int len1 = word1.length();
        int len2 = word2.length();
        //初始化一个二维数组
        int[][] answers = new int[len1 + 1][len2 + 1];
        //初始化第一列的数据
        for (int i = 0; i < len1 + 1; i++) {
            answers[i][0] = i;
        }
        //初始化第一行的数据
        for (int i = 0; i < len2 + 1; i++) {
            answers[0][i] = i;
        }
        //从第二行第二列开始看起
        for (int row = 1; row < len1 + 1; row++) {
            for (int col = 1; col < len2 + 1; col++) {
                answers[row][col] = Math.min(answers[row - 1][col], answers[row][col]) + 1;
                //判断字符是不是相同
                if (word1.charAt(row - 1) == word2.charAt(col - 1)) {
                    //当前字符相同
                    answers[row][col] = Math.min(answers[row][col], answers[row - 1][col - 1]);
                } else {
                    //当前字符不相等, 还需要在变换一次
                    answers[row][col] = Math.min(answers[row][col], answers[row - 1][col - 1] + 1);
                }
            }
        }
        return answers[len1][len2];
    }
}
