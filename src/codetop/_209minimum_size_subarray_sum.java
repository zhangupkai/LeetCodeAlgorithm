package codetop;

/**
 * @Description
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/3/3 9:33
 */
public class _209minimum_size_subarray_sum {

    // 滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        // 滑动窗口的左指针
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 当前子数组的和大于target，sum的值减去nums[left]，并将left右移
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
