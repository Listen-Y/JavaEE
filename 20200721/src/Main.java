import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(" ");
            String a = strings[0];
            String b = strings[1];
            if (aAllContainsB(a, b)) {
                Map<Character, Integer> mapA = new HashMap<>();
                Map<Character, Integer> mapB = new HashMap<>();
                putAllMap(mapA, a);
                putAllMap(mapB, b);
                if (aAllBig(mapA, mapB)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        }

    }

    private static boolean aAllBig(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {

        for (Map.Entry<Character, Integer> e : mapB.entrySet()
             ) {
            if (e.getValue() > mapA.get(e.getKey())) {
                return false;
            }
        }
        return true;

    }

    private static void putAllMap(Map<Character, Integer> mapA, String a) {

        for (int i = 0; i < a.length(); i++) {
            mapA.put(a.charAt(i), mapA.getOrDefault(a.charAt(i), 0) + 1);
        }

    }

    private static boolean aAllContainsB(String a, String b) {

        for (int i = 0; i < b.length(); i++) {
            if (! a.contains(String.valueOf(b.charAt(i)))) {
                return false;
            }
        }
        return true;

    }

}
