/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-12
 * Time: 10:05
 */
public class Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*System.out.println(solution.uniquePaths(1, 1));*/
     /*   int[] nums = null;
        System.out.println(nums == null);*/
     int[][] nums = new int[][] {{2, 1, 1}, {3, 2,0 }, {1, 0, 2}};
        //System.out.println(solution.uniquePathsWithObstacles(nums));
        System.out.println(solution.minPathSum(nums));
    }
}
