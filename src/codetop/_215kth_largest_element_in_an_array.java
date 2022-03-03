package codetop;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * @Author Kai
 * @Date 2022/3/3 15:13
 */
public class _215kth_largest_element_in_an_array {
    public int findKthLargest(int[] nums, int k) {

        // 第k大的值：建立小顶堆，并维持堆的大小为k个，如果新的数入堆后堆的大小大于等于k，则需要将堆顶的数和新的数进行比较，并将较小的移除
        // 这样可以保证堆中的数字是全体数字中最大的k个，堆顶的数字就是第k大的值（最大的k个数中最小的那个）
        // 大小为k的最小堆
        Queue<Integer> priorityQueue = new PriorityQueue<>(k, (o1, o2) -> o1 - o2);

        for (int i = 0; i < k; i++) {
            priorityQueue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > priorityQueue.element()) {
                // 替换堆顶元素为 较大值
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
        }

        return priorityQueue.element();
    }

    public int findKthLargest1(int[] nums, int k) {

        // 降序，最大堆
        Queue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int num : nums) {
            priorityQueue.offer(num);
        }

        int res = 0;
        for (int i = 0; i < k; i++) {
            res = priorityQueue.poll();
        }

        return res;
    }
}
