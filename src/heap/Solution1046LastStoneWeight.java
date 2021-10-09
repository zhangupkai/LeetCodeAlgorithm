package heap;

import java.util.PriorityQueue;

/**
 * @Description
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 *
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/last-stone-weight
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/11/17 10:52
 */
public class Solution1046LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        int size = stones.length;
        // 自定义Comparator，return o2 - o1 为降序，最大值优先级最高，最先出队
        // 优先队列实现的大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() >= 2) {
            // 最重的石头
            Integer y = maxHeap.poll();
            // 第二重的石头
            Integer x = maxHeap.poll();

            if (!x.equals(y)) {
                maxHeap.offer(y - x);
            }
        }

        if (maxHeap.size() == 1) {
            return maxHeap.peek();
        }

        return 0;
    }
}
