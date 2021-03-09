import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * 给定一个无重复元素的有序整数数组 nums
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * @Author Kai
 * @Date 2020/12/30 10:17
 */
// https://leetcode-cn.com/problems/summary-ranges/
public class Solution0228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; ++j) {
            // check if j + 1 extends the range [nums[i], nums[j]]
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
                continue;
            // put the range [nums[i], nums[j]] into the list
            if (i == j)
                summary.add(nums[i] + "");
            else
                summary.add(nums[i] + "->" + nums[j]);
            i = j + 1;
        }
        return summary;

        /*
        List<String> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }
        int tmp = nums[0];
        if (nums.length == 1) {
            list.add(String.valueOf(nums[0]));
            return list;
        }
        int[] numsCopy = Arrays.copyOf(nums, nums.length + 1);
        numsCopy[nums.length] = Integer.MAX_VALUE;
        for (int i = 1; i < numsCopy.length; i++) {
            System.out.println(numsCopy[i]);
            if (numsCopy[i] - numsCopy[i - 1] > 1) {
                if (tmp != numsCopy[i - 1]) {
                    list.add(tmp + "->" + numsCopy[i - 1]);
                }
                else {
                    list.add(String.valueOf(tmp));
                }
                tmp = numsCopy[i];
            }
        }
        return list;
         */
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
