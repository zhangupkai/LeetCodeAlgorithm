package heap;

import java.util.PriorityQueue;

/**
 * @Description 找出第 K 大的异或坐标值
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/11/19 10:40
 */
public class Solution1738FindKthLargestXorCoordinateValue {
    /**
     * 第k大的值：建立小顶堆，并维持堆的大小为k个，如果新的数入堆后堆的大小大于等于k，则需要将堆顶的数和新的数进行比较，并将较小的移除
     * 这样可以保证堆中的数字是全体数字中最大的k个，堆顶的数字就是第k大的值（最大的k个数中最小的那个）
     * @param matrix 二维矩阵
     * @param k k
     * @return 第k大的值
     */
    public static int kthLargestValue(int[][] matrix, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);

        int m = matrix.length, n = matrix[0].length;
        // 前缀和，首行首列全为0
        int[][] pre = new int[m + 1][n + 1];

        // 当我们将 pre(i−1,j) 和 pre(i,j−1) 进行按位异或运算后，由于对一个数 x 异或两次 y，结果仍然为 x 本身
        //因此 pre(i−1,j−1) 对应区域的按位异或结果被抵消，我们需要将其补上，并对位置 (i,j) 的元素进行按位异或运算，这样就得到了 pre(i,j)。
        //作者：LeetCode-Solution
        //链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/solution/zhao-chu-di-k-da-de-yi-huo-zuo-biao-zhi-mgick/
        //来源：力扣（LeetCode）
        //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j - 1] ^ pre[i - 1][j] ^ pre[i][j - 1] ^ matrix[i - 1][j - 1];
//                System.out.print(pre[i][j] + " ");
            }
//            System.out.println();
        }

        for (int i = 1; i < pre.length; i++) {
            for (int j = 1; j < pre[i].length; j++) {
                minHeap.offer(pre[i][j]);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 2}, {1, 6}};
        int k = 2;
        System.out.print(kthLargestValue(matrix, k));
    }
}
