import java.util.*;
class Solution {

    static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 在给定的网格中，每个单元格可以有以下三个值之一：
     *
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
     *
     * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotting-oranges
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {

        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;

        //需要一个队列保存坏的橘子
        Queue<Node> queue = new LinkedList<>();
        //遍历找到坏的橘子
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Node(i, j));
                }
            }
        }
        int time = 0;
        //如果此时有坏的橘子就进行处理感染
        while (!queue.isEmpty()) {
            //用一个数据判断是否进行了感染
            boolean ok = false;
            int size = queue.size();
            //进行一分钟的感染
            while (size-- > 0) {
                Node cur = queue.poll();
                //遍历该橘子的四周
                for (int i = 0; i < 4; i++) {
                    int newR = cur.x + next[i][0];
                    int newC = cur.y + next[i][1];
                    //判断边界
                    if (newR < 0 || newR >= row || newC < 0 || newC >= col) {
                        continue;
                    }
                    //判断如果当前是新鲜橘子就进行感染
                    if (grid[newR][newC] == 1) {
                        grid[newR][newC] = 2;
                        ok = true;
                        //并将感染后的橘子放到队列中
                        queue.offer(new Node(newR, newC));
                    }
                }
            }
            //如果有被感染
            if (ok) {
                time++;
            }
        }

        //检查如果还有没被感染的橘子就返回-1
        for (int[] ints : grid) {
            for (int j = 0; j < col; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //将所有单词放到hash表中 便于查询
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        //使用一个set去保存访问过的单词
        Set<String> used = new HashSet<>();
        used.add(beginWord);
        //使用一个队列去保存替换一次的单词
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
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
                        //如果这个单词就是结果 就返回step++
                        if (newWord.equals(endWord)) {
                            step++;
                            return step;
                        }
                        //否则判断这个新的单词是否在字典中是否被访问过
                        if (!dict.contains(newWord) && !used.contains(newWord)) {
                            queue.offer(newWord);
                            used.add(newWord);
                        }
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