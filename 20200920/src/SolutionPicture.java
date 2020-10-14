class Solution {

    private int[][] next = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void DFS(int[][] image, boolean[][] used, int sr, int sc, int newColor, int oldColor) {
        //首先将sr sc 设置为newColor
        image[sr][sc] = newColor;
        //设置该点已经被渲染
        used[sr][sc] = true;
        //遍历其上下左右所有节点
        for (int i = 0; i < 4; i++) {
            int nextSr = sr + next[i][0];
            int nextSc = sc + next[i][1];
            //检查边界
            if (nextSr < 0 || nextSr >= image.length || nextSc < 0 || nextSc >= image[0].length) continue;
            //检查这个点是否是oldColor并且这个点是不是被渲染过
            if (image[nextSr][nextSc] == oldColor && !used[nextSr][nextSc]) {
                DFS(image, used, nextSr, nextSc, newColor, oldColor);
            }
        }
    }

    /**
     * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
     *
     * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
     *
     * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
     *
     * 最后返回经过上色渲染后的图像。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flood-fill
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int row = image.length;
        if (row == 0) return image;
        int col = image[0].length;
        boolean[][] used = new boolean[row][col];
        DFS(image, used, sr, sc, newColor, image[sr][sc]);
        return image;
    }
}