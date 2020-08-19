
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int num = 0;
        int j = 0;
        long max = 0;

        List<Long> list = new ArrayList<>();
        while (j++ < n) {
            int i = sc.nextInt();
            long length = sc.nextLong();
            sc.nextLine();
            if (i == 1) {
                list.add(length);
                num += length;
            } else {
                list.remove( length);
                num -= length;
            }
            Collections.sort(list);

            if(list.size() > 0){
                max = list.get(list.size()-1);
            }
            if (num - max <= max) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
        }
    }
}