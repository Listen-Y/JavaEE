class Solution {

    private int[][] next = {{0 ,1}, {0, -1}, {1, 0}, {-1, 0}};

    private void DFS(char[][] board, boolean[][] used, int row, int col) {
        //将该点置为a
        board[row][col] = 'a';
        used[row][col] = true;
        //遍历其上下左右各点
        for (int i = 0; i < 4; i++) {
            int newRow = row + next[i][0];
            int newCol = col + next[i][1];
            //检查边界
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) continue;
            //检查是否为o并且判断是否已经遍历过
            if (board[newRow][newCol] == 'O' && !used[newRow][newCol]) {
                DFS(board, used, newRow, newCol);
            }
        }

    }

    /**
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     *
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     * 解释:
     *
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/surrounded-regions
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param board
     */
    public void solve(char[][] board) {

        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        //检查边界哪有o将其和与其相连的置为'a'
        boolean[][] used = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            //判断第一行
            if (board[0][i] == 'O') DFS(board, used, 0, i);
            //判断最后一行
            if (board[row - 1][i] == 'O') DFS(board, used, row - 1, i);
        }
        for (int i = 0; i < row; i ++) {
            //判断第一列
            if (board[i][0] == 'O') DFS(board, used, i, 0);
            //判断最后一列
            if (board[i][col - 1] == 'O') DFS(board, used, i, col - 1);
        }
        //恢复a -> O 并且将其余的o置为x
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'a') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}