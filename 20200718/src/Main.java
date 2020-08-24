import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Integer> days;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        days = new HashMap<>();
        days.put(1, 31);
        days.put(2, 28);
        days.put(3, 31);
        days.put(4, 30);
        days.put(5, 31);
        days.put(6, 30);
        days.put(7, 31);
        days.put(8, 31);
        days.put(9, 30);
        days.put(10, 31);
        days.put(11, 30);
        days.put(12, 31);

        while (scanner.hasNext()) {

            int year = scanner.nextInt();
            int mouth = scanner.nextInt();
            int day = scanner.nextInt();

            if (legitimate(year, mouth, day)) {

                if (leapYear(year)) {
                    int sum = 1;
                    for (int i = 1; i < mouth; i++) {
                        sum += days.get(i);
                    }
                    sum += day;
                    System.out.println(sum);
                } else {
                    int sum = 0;
                    for (int i = 1; i <mouth ; i++) {
                        sum += days.get(i);
                    }
                    sum += day;
                    System.out.println(sum);
                }

            } else {
                System.out.println(-1);
            }

        }

    }

    private static boolean leapYear(int year) {

        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        return year % 100 == 0 && year % 400 == 0;

    }

    private static boolean legitimate(int year, int mouth, int day) {

        if (year <= 0) {
            return false;
        }
        if (mouth <= 0 || mouth > 12) {
            return false;
        }
        int num = days.get(mouth);
        return day > 0 && day <= num;

    }

}
