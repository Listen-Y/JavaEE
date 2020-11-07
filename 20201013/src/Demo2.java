/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-13
 * Time: 10:31
 */
public class Demo2 {

    public static void main(String[] args) {

    }
}

class FinalExample {

    int i;
    final int j;
    static FinalExample obj;

    public FinalExample() {
        this.i = 1; //写普通域
        this.j = 2; //写final域
    }

    public static void write() {  //A线程执行
        obj = new FinalExample();
    }

    public static void read() {  //B线程执行
        FinalExample object = obj;  //读取对象引用
        int a = object.i;  //读取普通域
        int b = object.j;  //读取final域
    }
}

class FinalReferenceExample {
    final int[] array;
    static FinalReferenceExample obj;

    private FinalReferenceExample() {
        array = new int[1];
        array[0] = 1;
    }

    public static void writeOne() {
        obj = new FinalReferenceExample();
    }

    public static void writeTwo() {
        obj.array[0] = 2;
    }

    public static void read() {
        if (obj != null) {
            System.out.println(obj.array[0]);
        }
    }
}
