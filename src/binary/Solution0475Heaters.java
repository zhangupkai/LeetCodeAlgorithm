package binary;

import java.util.Arrays;

/**
 * @Description
 * 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 *
 * 现在，给出位于一条水平线上的房屋houses 和供暖器heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/1/17 20:49
 */
/*
为了使供暖器可以覆盖所有房屋且供暖器的加热半径最小，对于每个房屋，应该选择离该房屋最近的供暖器覆盖该房屋，最近的供暖器和房屋的距离即为该房屋需要的供暖器的最小加热半径。
所有房屋需要的供暖器的最小加热半径中的最大值即为可以覆盖所有房屋的最小加热半径。
为了得到距离每个房屋最近的供暖器，可以将供暖器数组 heaters 排序，然后通过二分查找得到距离最近的供暖器。
具体而言，对于每个房屋 house，需要在有序数组heaters 中找到最大的下标 i，使得 heaters[i]≤house，特别地，当 heaters[0]>house 时，i = -1。
在得到下标 i 之后，令 j = i + 1，则 j 是满足 heaters[j]>house 的最小下标。特别地，当 heaters[n−1]≤house 时，j = n，
其中 n 是数组heaters 的长度。
得到下标 i 和 j 之后，离房屋 house 最近的供暖器为heaters[i] 或 heaters[j]，分别计算这两个供暖器和房屋 house 的距离，
其中的最小值即为该房屋需要的供暖器的最小加热半径。对于 i = -1 或 j = n 的下标越界情况，只要将对应的距离设为 +∞ 即可。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/heaters/solution/gong-nuan-qi-by-leetcode-solution-rwui/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
    //TODO 没完全搞懂
public class Solution0475Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        // 将供暖器数组 heaters 排序，然后通过二分查找得到距离最近的供暖器
        Arrays.sort(heaters);
        for (int house : houses) {
            // 房屋house左侧最近的供暖器heaters下标
            int i = binarySearch(heaters, house);
            // 房屋house右侧最近的供暖器heaters下标
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            // 当前房屋所需的供暖器最小半径为左侧和右侧暖器中最小的
            int curDistance = Math.min(leftDistance, rightDistance);
            ans = Math.max(ans, curDistance);
        }

        return ans;
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // 第一个供暖器在房屋右侧，即房屋左侧没有供暖期，离房屋最近的供暖器只能在房屋右侧
        if (nums[left] > target) {
            return -1;
        }

        // left = mid 导致 循环条件不能再是 left <= right
        while (left < right) {
            // TODO: + 1 的原因：
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            }
            else {
                // left = mid，而不是left = mid + 1，因为目标house位置可能没有heater，导致匹配不到
                left = mid;
            }
        }
        return left;
    }
}
