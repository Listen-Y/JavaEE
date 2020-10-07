import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-11
 * Time: 19:35
 */
public class Solution {

    /**
     * 三角矩阵
     * @param triangle
     * @return
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {

        if (triangle == null) return 0;
        if (triangle.isEmpty()) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0); //只有一行数据的时候

        //row表示行
        for (int row = 1; row < triangle.size(); row++) {
            //col表示列
            for (int col = 0; col < triangle.get(row).size(); col++) {
                if (col == 0) {
                    //第一个, 直接加上一行第一个就行
                    triangle.get(row).set(col, triangle.get(row - 1).get(0) + triangle.get(row).get(0));
                } else if (col == row) {
                    //每一行最后一个数据
                    triangle.get(row).set(col, triangle.get(row - 1).get(row - 1) + triangle.get(row).get(col));
                } else {
                    triangle.get(row).set(col, Math.min(triangle.get(row - 1).get(col - 1), triangle.get(row - 1).get(col))
                            + triangle.get(row).get(col));
                }
            }
        }
        //返回最后一行的最小的那个数字
        ArrayList<Integer> numList = triangle.get(triangle.size() - 1);
        int ret = numList.get(0);
        for (int i = 1; i < numList.size(); i++) {
            ret = Math.min(ret, numList.get(i));
        }
        return ret;
    }


    public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {

        if (triangle == null) return 0;
        if (triangle.isEmpty()) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0); //只有一行数据的时候

        for (int row = triangle.size() - 1 - 1; row >= 0; row--) {
            for (int col = 0; col < row + 1; col++) {
                triangle.get(row).set(col, Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1))
                        + triangle.get(row).get(col));
            }
        }
        return triangle.get(0).get(0);
    }
}
