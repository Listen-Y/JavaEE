/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-12
 * Time: 9:59
 */
public class Solution {

    /**
     * 路径总数(Unique Paths)
     * @param "m行数"
     * @param "n列数"
     * @return
     */
    public int uniquePaths(int m, int n) {

        if (m == 0 || n== 0) return 0;

        //构建二维数组
        int[][] answers = new int[m][n];
        //将第一行和第一列初始化为1
        for (int i = 0; i < n; i++) {
            answers[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            answers[i][0] = 1;
        }
        //从第二行第二列开始动态计算
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                answers[row][col] = answers[row - 1][col] + answers[row][col - 1];
            }
        }
        return answers[m - 1][n - 1];
    }


    /**
     * 带权路径总数(Unique Paths II)
     * @param obstacleGrid
     * @return
     */
     public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid == null) return 0;
        if (obstacleGrid.length == 0) return 0;
        if (obstacleGrid[0].length == 0) return 0;

        //构建二维数组
         int[][] answers = new int[obstacleGrid.length][obstacleGrid[0].length];
         //第一行和第一列的设置
         for (int col = 0; col < obstacleGrid[0].length; col++) {
             if (obstacleGrid[0][col] == 1) {
                 //遇到1表示走不通, 退出循环
                 break;
             } else {
                 answers[0][col] = 1;
             }
         }
         for (int row = 0; row < obstacleGrid.length; row++) {
             if (obstacleGrid[row][0] == 1) {
                 break;
             } else {
                 answers[row][0] = 1;
             }
         }
         //从第二行第二列开始算起
         for (int row = 1; row < obstacleGrid.length; row++) {
             for (int col = 1; col < obstacleGrid[0].length; col++) {
                 if (obstacleGrid[row][col] == 1) {
                     answers[row][col] = 0;
                 } else {
                     answers[row][col] = answers[row - 1][col] + answers[row][col - 1];
                 }
             }
         }
         return answers[obstacleGrid.length - 1][obstacleGrid[0].length - 1];

     }

    /**
     * 最小路径和(Minimum Path Sum)
     * @param grid
     * @return
     */
     public int minPathSum(int[][] grid) {

         if (grid == null) return 0;
         if (grid.length == 0) return 0;
         if (grid[0].length == 0) return 0;

         //第一行和第一列数据 形成累加
         for (int row = 1; row < grid.length; row++) {
             grid[row][0] += grid[row - 1][0];
         }
         for (int col = 1; col < grid[0].length; col++) {
             grid[0][col] += grid[0][col - 1];
         }

         //从第二行第二列开始运算
         for (int row = 1; row < grid.length; row++) {
             for (int col = 1; col < grid[0].length; col++) {
                 grid[row][col] = Math.min(grid[row - 1][col], grid[row][col - 1])
                         + grid[row][col];
             }
         }
         return grid[grid.length - 1][grid[0].length - 1];
     }



}
