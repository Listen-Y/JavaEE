import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-30
 * Time: 18:39
 */
public class Demo {

    public static void main(String[] args) {
        SortTest sortTest = new SortTest();
        int[] array = new int[] {9,8,7,6,5,4,3,2,1,0};
        sortTest.quickSortByLoop(array);
        //sortTest.mergeSortByLoop(array);
        //sortTest.shellSort(array);
        //sortTest.quickSort(array);
        //sortTest.mergeSort(array);
        //sortTest.insertSort(array);
        //sortTest.headSort(array);
        //sortTest.chanceSort(array);
        //sortTest.bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
