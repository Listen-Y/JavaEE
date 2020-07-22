import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (scanner.hasNext()) {
            String sss = scanner.nextLine();
            String s = scanner.nextLine();
            String[] strings1 = s.split(" ");
        int n1 = Integer.parseInt(strings1[0]);
        int n2 = Integer.parseInt(strings1[1]);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
            n1  = strings.length / 2 + 1;

            StringBuilder leftHand = new StringBuilder();
        StringBuilder rightHand = new StringBuilder();

            for (int i = 0; i < n1; i++) {
                leftHand.append(strings[i].charAt(0));
            }

            for (int i = n1; i < 2 * n1; i++) {
                rightHand.append(strings[i].charAt(0));
            }


            System.out.println(leftHand.toString());
            System.out.println(rightHand.toString());

            StringBuilder ret = new StringBuilder();
            for (int i = n1 - 1; i >= 0; i--) {
                ret.append(rightHand.charAt(i));
                ret.append(" ");
                ret.append(leftHand.charAt(i));
                ret.append(" ");
            }

            ret.reverse();
            ret.deleteCharAt(0);
            System.out.println(ret);
        }

    }
}
