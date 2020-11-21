/**
 * @Description
 * @Author Kai
 * @Date 2020/11/21 19:42
 */
// https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays/
// 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
// 子数组: 定义为原数组中的一个连续子序列。
// 请你返回arr中所有奇数长度子数组的和 。

public class Solution1588 {
    /**
     * 暴力三层循环
     * @param arr 传入数组
     * @return sum
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int window = 1; window <= arr.length; window += 2){
            for (int L = 0, R = L + window; R <= arr.length; L++, R++){
                for (int i = L; i < R; i++){
                    sum += arr[i];
                }
            }
        }
        return sum;
    }

    //TODO 优化解法
}
