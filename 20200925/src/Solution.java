import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-25
 * Time: 11:02
 */
class Solution {
    //保存x y节点的node
    static class Node {
        public int row;
        public int col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node cur = (Node) o;
            return cur.col == this.col && cur.row == this.row;


        }
    }

    //用于保存所有的解法
    private List<List<Node>> solutions;

    private void DFS(List<Node> queen, int curRow, int n) {
        //如果当前保存的queen的数量等于了n就说明是一种解决方案
        if (queen.size() == n) {
            //拷贝一份当前的queen
            List<Node> curQueen = new ArrayList<>();
            for (Node node : queen) {
                curQueen.add(node);
            }
            solutions.add(curQueen);
            return;
        }
        //遍历这一行的每一个位置
        for (int col = 0; col < n; col++) {
            //判断此时的位置是否可以放置皇后
            if (can(queen, curRow, col)) {
                queen.add(new Node(curRow, col));
                DFS(queen, curRow + 1, n);
                //回溯
                queen.remove(queen.size() - 1);
            }
        }
    }

    private boolean can(List<Node> queen, int row, int col) {
        //遍历此时保存的每一个皇后的node 看当前位置是否合法
        for (Node node : queen) {
            if (node.col == col || node.row + node.col == row + col || node.row - node.col == row - col) {
                return false;
            }
        }
        return true;
    }

    private List<List<String>> makeRet(int n) {
        List<List<String>> ret = new ArrayList<>();
        //遍历结果集
        for (List<Node> list : solutions) {
            //初始化一个保存结果的链表
            List<String> curRet = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder str = new StringBuilder();
                for (int col = 0; col < n; col++) {
                    //如果当前位置是皇后就保存Q 不是就保存一个.
                    if (list.contains(new Node(row, col))) {
                        str.append("Q");
                    } else {
                        str.append(".");
                    }
                }
                curRet.add(str.toString());
            }
            ret.add(curRet);
        }
        return ret;
    }

    /**
     * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     *
     *
     * 上图为 8 皇后问题的一种解法。
     *
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     *
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-queens
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        //初始化
        solutions = new ArrayList<>();
        List<Node> queen = new ArrayList<>();
        DFS(queen, 0, n);
        //结果导出
        return makeRet(n);

    }
}
