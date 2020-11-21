/**
 * @Description
 * @Author Kai
 * @Date 2020/11/21 19:17
 */
// https://leetcode-cn.com/problems/squares-of-a-sorted-array/
// 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
public class Solution0977 {
    public int[] sortedSquares(int[] A) {
        // 首尾双指针
        // 使用两个指针分别指向位置 0 和 n-1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, cur = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[cur--] = A[i] * A[i];
                i++;
            }
            else {
                ans[cur--] = A[j] * A[j];
                j--;
            }
        }
        return ans;
    }
}
