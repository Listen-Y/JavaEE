package com.main;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-04
 * Time: 20:26
 */

public class Main1 {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String line = scan.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (!list.contains(ch)) list.add(ch);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            list.sort((o1, o2) -> o1 - o2);
            for (Character character : list) {
                System.out.print(character+":");
                System.out.println(map.get(character));
            }
        }
    }

    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(10, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for (int i = 1; i < 30; i++) {
            int count = i;
            StringBuilder s = new StringBuilder();
            while (count > 0) {
                s.append(i);
                count--;
            }
            if (priorityQueue.size() == 10) priorityQueue.poll();
            priorityQueue.add(s.toString());

        }
        //System.out.println(Arrays.toString(priorityQueue.toArray()));
        System.out.println(priorityQueue.toString());
        System.out.println(priorityQueue.size());
    }
}
