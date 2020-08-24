import java.util.*;

public class Main {

    private static Map<Integer, String> map;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        map = new HashMap<>();
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PQRS");
        map.put(8, "TUV");
        map.put(9, "WXYZ");

        while (scanner.hasNext()) {
            Set<String> set = new HashSet<>();
            int n = scanner.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.next();
            }
            for (int i = 0; i < n; i++) {
                set.add(func(strings[i].replaceAll("-", "").toUpperCase()));
            }
            List<String> list = new ArrayList<>(set);
            Collections.sort(list);
            for (String s : list
                 ) {
                System.out.println(s);
            }
            System.out.println();
        }

    }

    private static String func(String string) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            if (i == 3) {
                builder.append("-");
            }
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9') {
                builder.append(string.charAt(i));
                continue;
            }
            for (Map.Entry<Integer, String> entry : map.entrySet()
                 ) {
                if (entry.getValue().contains(String.valueOf(string.charAt(i)))) {
                    builder.append(entry.getKey());
                    break;
                }
            }
        }
        return builder.toString();

    }

}
