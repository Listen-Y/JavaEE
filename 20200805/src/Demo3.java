import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-05
 * Time: 21:34
 */
public class Demo3 {

    static class Test {

        static int num = 0;

        public int func() {

            num++;
            return num;
        }
    }

    public static void main(String[] args) {
        /*Test test = new Test();
        System.out.println(test.func());
        System.out.println(test.func());*/

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        switch (s) {
            case "a":
                System.out.println("aaa");
                break;
            case "b":
                System.out.println("nnn");
                break;
            default:
                System.out.println("default");
        }

    }

    void func() throws InterruptedException {
        Object object = new Object();
        synchronized (Thread.currentThread()) {
            object.wait();
            object.notify();
        }
    }

}
