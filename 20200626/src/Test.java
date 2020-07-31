public class Test {
    public static void main(String[] args) {
        System.out.println(func(35, 21));
    }

    private static int func(int x, int a) {

        int num = a;
        while (x % num != 0 || a % num != 0) {
            num--;
        }
        return num;
    }
}
