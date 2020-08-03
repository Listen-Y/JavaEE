import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    private static List<Character> candidate = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            candidate.clear();
            int n = Integer.parseInt(scanner.nextLine());
            String[] candidates = scanner.nextLine().split(" ");
            int m = Integer.parseInt(scanner.nextLine());
            String[] votes = scanner.nextLine().split(" ");

            for (String s : candidates
                 ) {
                AddCandidate(s);
            }
            int[] count = new int[n];
            int Invalid = 0;
            for (int i = 0; i < m; i++) {
                if (!candidate.contains(votes[i].charAt(0))) {
                    Invalid++;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (candidate.get(i) == votes[j].charAt(0)) {
                        count[i]++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.println(candidate.get(i) + " : " + count[i]);
            }
            System.out.println("Invalid : " + Invalid);
        }
    }

    private static void AddCandidate(String s) {
        if (candidate.contains(s.charAt(0))) {
            return;
        }
        candidate.add(s.charAt(0));
    }
}
