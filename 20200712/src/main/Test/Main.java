import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            List<Long> list = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                String[] lineTokens = scanner.nextLine().split(" ");
                int key = Integer.parseInt(lineTokens[0]);
                long length = Long.parseLong(lineTokens[1]);

                if (key == 1) {
                    list.add(length);
                } else {
                    list.remove(length);
                }

                if (funcOk(list)) {
                    System.out.println("Yse");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    private static boolean funcOk(List<Long> list) {
        if (list.size() < 3) {
            return false;
        }
        List<Long> list1 = new LinkedList<>(list);

          while (list1.size() > 3) {
              Collections.sort(list1);
              long sum = list1.get(0) + list1.get(1);
              list1.remove(0);
              list1.remove(1);
              list1.add(sum);
          }

        return anyTwoBigOne(list1);
    }

    private static boolean anyTwoBigOne(List<Long> list1) {
        long a = list1.get(0);
        long b = list1.get(1);
        long c = list1.get(2);
        return a + b > c && a + c > b && b + c > a;
    }
}
