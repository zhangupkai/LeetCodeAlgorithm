/**
 * @Description
 * @Author Kai
 * @Date 2020/11/21 16:02
 */
public class SolutionInterview1710 {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        // 投票找出众数（但是众数不一定数量超过半数，所以找出众数后还需要验证）
        int tmp = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
             if (nums[i] == tmp) {
                 count++;
             }
             else {
                 count--;
             }
             if (count == 0) {
                 tmp = nums[i];
                 count++;
             }
        }

        // 验证是否超过半数
        count = 0;
        for (int num : nums) {
            if (num == tmp) {
                count++;
            }
            if (count == nums.length / 2 + 1) {
                return tmp;
            }
        }
        return -1;
    }
}
