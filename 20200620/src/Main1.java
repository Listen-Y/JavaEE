public class Main1 {
    public static void main(String[] args) {
        int fich = 10;
        int poor = 1;
        int sumPoor = 0;
        for (int i = 0; i < 30; i++) {
            sumPoor += poor;
            poor *= 2;
        }
        System.out.println(fich * 30 + " " + sumPoor);
        String s = "abc";
        //System.out.println(sumPoor);
        //System.out.println(Math.pow(2,) - 1);
    }
}
