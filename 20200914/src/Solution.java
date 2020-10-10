/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-14
 * Time: 13:42
 */
public class Solution {

    /**
     * 不同子序列(Distinct Subsequences)
     * @param S
     * @param T
     * @return
     */
    public int numDistinct(String S, String T) {

        if (T == null && S == null) return 1;
        if (S == null || S.length() == 0) return 0;
        if (T == null || T.length() == 0) return 1;

        int len1 = S.length();
        int len2 = T.length();
        //构建二维数组
        int[][] answers = new int[len1 + 1][len2 + 1];
        //第一行表示S为空 所以是0
        //第一列表示T为空 所以是1
        for (int i = 0; i < len1 + 1; i++) {
            answers[i][0] = 1;
        }
        //从第二行第二列开始计算数目
        for (int row = 1; row < len1 + 1; row++) {
            for (int col = 1; col < len2 + 1; col++) {
                //判断当前字符是不是相等
                if (S.charAt(row - 1) == T.charAt(col - 1)) {
                    //表示相等
                    answers[row][col] = answers[row - 1][col - 1] + answers[row - 1][col];
                } else {
                    //表示不相等
                    answers[row][col] = answers[row - 1][col];
                }
            }
        }
        return answers[len1][len2];
    }

    //内存优化
    public int numDistinct2(String S, String T) {
        if (T == null && S == null) return 1;
        if (S == null || S.length() == 0) return 0;
        if (T == null || T.length() == 0) return 1;

        //构建一个一维数组长度是T的长度加一
        int[] answers = new int[T.length() + 1];
        //第一个数字设置为1其余为0
        answers[0] = 1;
        //从第二行第二列开始看起
        for (int row = 1; row < S.length()+ 1; row++) {
            //为了不影响前面数据计算 必须从后往前计算
            for (int col = T.length(); col > 0; col--) {
                //这里的操作还是判断当前字符是不是相等
                if (S.charAt(row - 1) == T.charAt(col - 1)) {
                    //当前字符相等
                    answers[col] += answers[col - 1];
                }
            }
        }
        return answers[T.length()];
    }
}
