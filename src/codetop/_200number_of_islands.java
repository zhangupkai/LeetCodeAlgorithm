package codetop;

/**
 * @Description 岛屿数量
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/3/8 21:24
 */
public class _200number_of_islands {

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // dfs 会将所有与 当前位置相连的 未访问过的陆地(1) 变成 已访问过的陆地(2)
                // 因此，在后续遍历中，这些陆地不会再被计数
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int r, int c) {
        // 判断当前坐标是否越界，类似于二叉树DFS中的 node == null
        if (!inArea(grid, r, c)) {
            return;
        }
        // 当前坐标不是 未访问过的陆地(1)
        if (grid[r][c] != '1') {
            return;
        }
        // 当前坐标设置成 已访问过的陆地(2)
        grid[r][c] = '2';
        // 访问上、下、左、右四个相邻网格，类似于二叉树DFS中访问左右子节点
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    // 坐标 (r, c) 是否在网格 grid 中
    private boolean inArea(char[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}
