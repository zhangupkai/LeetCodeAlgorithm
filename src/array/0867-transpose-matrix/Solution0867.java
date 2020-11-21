/**
 * @Description
 * @Author Kai
 * @Date 2020/11/21 15:43
 */
// https://leetcode-cn.com/problems/transpose-matrix/
// 求矩阵的转置
public class Solution0867 {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] ans = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][i] = A[i][j];
            }
        }
        return ans;
    }
}
