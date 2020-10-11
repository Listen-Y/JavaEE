class Solution10 {

    private int[][] next = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    private void DFS(char[][] grid, int row, int col) {
        //现将该点置为0
        grid[row][col] = '0';
        //遍历其上下左右各点
        for (int i = 0; i < 4; i++) {
            int newRow = row + next[i][0];
            int newCol = col + next[i][1];
            //检验边界合法性
            if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) continue;
            //判断其是否为1
            if (grid[newRow][newCol] == '1') {
                DFS(grid, newRow, newCol);
            }
        }
    }

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;

        //遍历二维数组 只要发现是1就count++
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    //是陆地
                    count++;
                    DFS(grid, i, j);
                }
            }
        }
        return count;
    }
}