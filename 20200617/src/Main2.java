import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            if (N == 0) {
                break;
            }

            int[] students = new int[N];
            for (int i = 0; i < N; i++) {
                students[i] = scanner.nextInt();
            }

            int key = scanner.nextInt();

            int count = 0;

            for (int i : students
                 ) {
                if (i == key) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
