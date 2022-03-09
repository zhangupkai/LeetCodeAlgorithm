package codetop;

/**
 * @Description 岛屿的最大面积
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 *
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 *
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/3/9 10:13
 */
public class _695max_area_of_island {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans = Math.max(ans, dfs(grid, i, j));
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] grid, int r, int c) {
        // 判断当前坐标是否越界，类似于二叉树DFS中的 node == null
        if (!inArea(grid, r, c)) {
            return 0;
        }
        // 当前坐标不是 未访问过的陆地(1)
        if (grid[r][c] != 1) {
            return 0;
        }
        // 当前坐标设置成 已访问过的陆地(2)
        grid[r][c] = 2;
        // 访问上、下、左、右四个相邻网格，类似于二叉树DFS中访问左右子节点
        return 1
                + dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }

    private boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
