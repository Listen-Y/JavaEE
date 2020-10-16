import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-22
 * Time: 21:34
 */
public class SolutionBreadth {

    static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 迷宫问题
     */
    public static void main(String[] args) {
        int sr, sc, endR, endC;
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入迷宫起点与终点:");
        sr = scanner.nextByte();
        sc = scanner.nextByte();
        endR = scanner.nextByte();
        endC = scanner.nextByte();
        int[][] gird = {{0,1,0,0},
                        {0,0,0,1},
                        {0,1,0,0},
                        {0,0,1,0}};
        System.out.println(DFS(gird, sr, sc, endR, endC));

    }

    private static int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean DFS(int[][] gird, int sr, int sc, int endR, int endC) {

        int row = gird.length;
        if (row == 0) {
            return false;
        }
        int col = gird[0].length;
        //需要一个used保存访问过得点
        boolean[][] used = new boolean[row][col];
        //需要一个队列保存需要遍历的点
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sr, sc));
        //标记起点已被使用
        used[sr][sc] = true;

        //只要队列不为空就说明还有机会到达终点
        while (!queue.isEmpty()) {
            //查看起点的四周, 看哪个方向可以走
            for (int i = 0; i < 4; i++) {
                int newX = queue.peek().x + next[i][0];
                int newY = queue.peek().y + next[i][1];
                //判断边界
                if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                    continue;
                }
                //如果此时位置无障碍, 并且未被访问就入队列
                if (gird[newX][newY] == 0 && !used[newX][newY]) {
                    queue.offer(new Node(newX, newY));
                    //并标记这点被访问过
                    used[newX][newY] = true;
                }
                //如果此时已经是终点就结束方法
                if (newX == endR && newY == endC) {
                    return true;
                }
            }
            //否则就出队列判断下一个点
            queue.poll();
        }
        return false;
    }
}
