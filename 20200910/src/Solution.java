/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-12
 * Time: 16:44
 */
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        if (m == 0) return 0;
        if (A == null || V == null) return 0;
        if (A.length == 0 || V.length == 0) return 0;

        //构建二维数组存放最大值
        int[][] answers = new int[A.length + 1][m + 1];

        //java在初始化数组的时候已经默认全填充为0
        //所以直接按第二行第二列开始运算即可
        //行表示放的第几个物品
        //列表示此时包的大小
        for (int row = 1; row < answers.length; row++) {
            for (int col = 1; col < m + 1; col ++) {
                if (col >= A[row - 1]) {
                    //放的下
                    answers[row][col] = Math.max(V[row - 1] + answers[row - 1][col - A[row - 1]], answers[row - 1][col]);
                } else {
                    //表示放不下
                    answers[row][col] = answers[row - 1][col];
                }
            }
        }
        //返回最后一个数据
        return answers[A.length][m];
    }

    public int backPackII2(int m, int[] A, int[] V) {
        if (m == 0) return 0;
        if (A == null || V == null) return 0;
        if (A.length == 0 || V.length == 0) return 0;
        //只用一维数组表示上一行的情况就行
        //这个数组的长度就是包的最大值加一
        int[] answers = new int[m + 1];
        //还是从第一个物品开始计算
        for (int row = 1; row < A.length + 1; row++) {
            //在判断放下放不下的时候因为我们保保存的是一行数据
            //所以要从后往前遍历
            for (int col = m; col >= 1; col--) {
                if (col >= A[row - 1]) {
                    //表示放的下
                    answers[col] = Math.max(V[row - 1] + answers[col - A[row - 1]], answers[col]);
                }
            }
        }
        return answers[m];
    }
}
