package heap;

import java.util.PriorityQueue;

/**
 * @Description Solution0295 数据流的中位数
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4]的中位数是 3
 *
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 *
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-median-from-data-stream
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/12/21 19:56
 */
public class MedianFinder {

    /*
    实际上是求第 k 小的数
    如果列表长度是奇数，那么 k 就是 (n+1)/2，中位数就是第 k 个数
    如果列表长度是偶数，那么 k 就是 (n+1)/2 和 (n+1)/2+1
     */

    // 奇数个时，大顶堆多一个元素；偶数个时，大顶堆和小顶堆元素一样多
    // 大顶堆，存放最小的 (n+1)/2 个数，堆顶是第 (n+1)/2 小的数，奇数情况的中位数
    private PriorityQueue<Integer> maxHeap;
    // 小顶堆，存放最大的 n-(n+1)/2 个数，堆顶是第 n-(n+1)/2 大的数，结合上面的大顶堆，可求出偶数情况的中位数。
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // num 小于等于 中位数，加入到大顶堆（最小的k个数）
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
            // 如果大顶堆的个数比小顶堆的个数多 2，那么就将大顶堆中最大的转移到小顶堆
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            }
        }
        else {
            minHeap.offer(num);
            // 如果大顶堆的个数比小顶堆少，那么就将小顶堆中最小的转移到大顶堆。
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        // 奇数个
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

}
