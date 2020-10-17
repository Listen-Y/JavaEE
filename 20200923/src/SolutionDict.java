import java.util.*;
class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //将所有单词放到hash表中 便于查询
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        //判断此时字典是否有这个endWord
        if (!dict.contains(endWord)) {
            return 0;
        }
        //使用一个set去保存访问过的单词
        Set<String> used = new HashSet<>();
        used.add(beginWord);
        //使用一个队列去保存替换一次的单词
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //计数器
        int step = 1;

        while (!queue.isEmpty()) {
            //取出一次变化后的说有单词
            int size = queue.size();
            while (size-- > 0) {
                String curWord = queue.poll();
                //对这个单词进行每一个位置的每一个字符的替换
                for (int i = 0; i < curWord.length(); i++) {
                    StringBuilder builder = new StringBuilder(curWord);
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        builder.setCharAt(i, ch);
                        String newWord = builder.toString();
                        //判断这个新单词是否在字典中 获取被访问过
                        if (!dict.contains(newWord) || used.contains(newWord)) {
                            continue;
                        }
                        //如果此时就是endWord就结束
                        if (newWord.equals(endWord)) {
                            return step + 1;
                        }
                        //否则入队列
                        queue.offer(newWord);
                        used.add(newWord);
                    }
                }
            }
            //完成所有size表示进行了一次改变
            step++;
        }
        //如果到这还没有返回说明不能扎到
        return 0;
    }
}