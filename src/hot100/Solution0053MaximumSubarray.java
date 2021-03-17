package hot100;

/**
 * @Description
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @Author Kai
 * @Date 2021/3/12 10:07
 */
public class Solution0053MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int pre = 0, maxSum = nums[0];
        for (int num : nums) {
            // 简化版的动态规划思想
            // 求出每个位置的 最大连续子数组和 maxSum
            // 对于每个位置，考虑其成为单独一段 nums[i]，还是加上前面的一段pre
            pre = Math.max(pre + num, num);
            maxSum = Math.max(pre, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

}
