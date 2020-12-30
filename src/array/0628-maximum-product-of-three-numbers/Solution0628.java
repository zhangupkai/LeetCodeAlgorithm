import java.util.Arrays;

/**
 * @Description
 * @Author Kai
 * @Date 2020/11/23 22:25
 */
// https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
// 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
public class Solution0628 {
    public int maximumProduct(int[] nums) {
        // 升序排序后
        // 都为正数：乘积最大值为排序数组最后三个数相乘
        // 都为负数：乘积最大值为排序数组最后三个数相乘
        // 有正有负：（1）乘积最大值为排序数组最后三个数相乘（2）乘积最大值为排序数组前两个负数与数组最后一个正数相乘
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1]);
    }

    public int maximumProduct1(int[] nums) {
        // 线性扫描，不用排序，找出数组中最大的三个数和最小的两个数
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (num >= max2) {
                max3 = max2;
                max2 = num;
            }
            else if (num >= max3){
                max3 = num;
            }

            if (num <= min1) {
                min2 = min1;
                min1 = num;
            }
            else if (num <= min2) {
                min2 = num;
            }
        }
        return Math.max(max3 * max2 * max1, min1 * min2 * max1);
    }
}
