/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-23
 * Time: 16:29
 */
public class Test {

    public static void main(String[] args)
    {
      /*  StringBuffer a = new StringBuffer("Runoob");
        StringBuffer b = new StringBuffer("Google");
        a.delete(1,3);
        a.append(b);
        System.out.println(a.toString());*/
      StringBuilder a = new StringBuilder("Runoob");
      StringBuilder b = new StringBuilder("Google");
      a.delete(1, 3);
      a.append(b);
        System.out.println(a);
    }

    public boolean Find(int target, int [][] array) {
        if (array == null) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;
        while (row < array.length && col >= 0) {
            if (target > array[row][col]) {
                row++;
            } else if (target < array[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

}
