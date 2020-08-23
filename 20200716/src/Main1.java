import com.sun.scenario.effect.impl.sw.java.JSWRendererDelegate;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(";");
            int x = 0;
            int y = 0;

            for (String str : strs) {
                if (hefa(str)) {
                    char key = str.charAt(0);
                    int step = Integer.parseInt(str.substring(1));
                    if (key == 'A') {
                        x -= step;
                    } else if (key == 'D') {
                        x += step;
                    } else if (key == 'W') {
                        y += step;
                    } else {
                        y -= step;
                    }
                }
            }

            System.out.println(x + "," + y);
        }
    }

    private static boolean hefa(String str) {

        if (str.length() > 3 || str.length() <= 1) {
            return false;
        }
        char c = str.charAt(0);
        if (c == 'A' || c == 'D' || c == 'W' || c== 'S') {
            if (str.length() == 3) {
                return str.charAt(1) >= '0' && str.charAt(1) <= '9'
                        && str.charAt(2) >= '0' && str.charAt(2) <= '9';
            } else {
                return str.charAt(1) >= '0' && str.charAt(1) <= '9';
            }
        }
        return false;
    }

    public static int getMaxSum(int [] array,int n){
        if(array.length==0||array == null)
            return 0;
        int currentSum = array[0];
        int currentMax = array[0];
        for(int i = 1;i<n;i++){
            if(currentSum<0){
                currentSum=array[i];
            }
            else{
                currentSum+=array[i];
            }
            if(currentSum>currentMax){
                currentMax=currentSum;
            }
        }
        return currentMax;
    }

    public static void main1(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int [] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = scan.nextInt();
        }

        System.out.println(getMaxSum(array, n));

    }

}