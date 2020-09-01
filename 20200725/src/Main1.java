import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-25
 * Time: 9:51
 */
public class Main1 {


    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        List<Integer> list = clockwisePrintByList(mat, n, m);
        return null;
    }

    private List<Integer> clockwisePrintByList(int[][] mat, int n, int m) {

        List<Integer> list = new ArrayList<>();
        //最上边一行
        for (int i = 0; i < m; i++) {
            list.add(mat[0][i]);
        }
        //最右边一列
        for (int i = 1; i < n; i++) {
            list.add(mat[m - 1][i]);
        }
        //最下边一行
        for (int i = m - 2; i >= 0 && n > 1; i++) {
            list.add(mat[n - 1][i]);
        }
        //最左边一列
        for (int i = n - 2; i > 0 && m > 1; i++) {
            list.add(mat[i][0]);
        }
        if (n > 2 || m > 2) {
            int[][] mat1 = new int[n - 2][m - 2];

        }
        return null;

    }

}
