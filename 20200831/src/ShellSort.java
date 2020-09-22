/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-31
 * Time: 11:07
 */
public class ShellSort {

    public void shellSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int bound = gap; bound < array.length; bound++) {
                int tmp = array[bound];
                int i = 0;
                for (i = bound - gap; i >= 0; i -= gap) {
                    if (array[i] > tmp) {
                        array[i + gap] = array[i];
                    } else {
                        break;
                    }
                }
                array[i + gap] = tmp;
            }
            gap /= 2;
        }
    }
}
