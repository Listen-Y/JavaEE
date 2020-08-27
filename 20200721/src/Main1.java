import java.util.*;

public class Main1 {

    static class Word {
        public String word;
        public List<String> brothers = new LinkedList<>();

        public Word(String word) {
            this.word = word;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            List<Word> dictionary = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = scanner.next();
                dictionary.add(new Word(str));
                makeBrother(dictionary, str);
                System.out.println(i + 1);
            }
            String key = scanner.next();
            int index = scanner.nextInt() - 1;
            allBrotherSort(dictionary);
            for (Word w : dictionary
                 ) {
                if (w.word.equals(key)) {
                    System.out.println(w.brothers.size() + " ");
                    if (index < w.brothers.size() && index >= 0) {
                        System.out.println(w.brothers.get(index));
                    }
                }
            }

        }

    }

    private static void allBrotherSort(List<Word> dictionary) {

        if (dictionary == null) {
            return;
        }
        for (Word word : dictionary
                ) {
            Collections.sort(word.brothers);
        }

    }

    private static void makeBrother(List<Word> dictionary, String str) {

        if (dictionary == null || str == null) {
            return;
        }
        for (Word word : dictionary) {
            if (isBrother(word.word, str)) {
                word.brothers.add(str);
            }
        }

    }

    private static boolean isBrother(String word, String str) {

        if (word == null || str == null) {
            return false;
        }
        if (word.length() != str.length()) {
            return false;
        }
        if (word.equals(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!word.contains(String.valueOf(str.charAt(i)))) {
                return false;
            }
        }
        return true;

    }

    private static boolean dicContainsStr(List<Word> dictionary, String str) {

        if (dictionary == null || str == null) {
            return false;
        }
        for (Word word : dictionary) {
            if (word.word.equals(str)) {
                return true;
            }
        }
        return false;

    }

}
