package binary;

/**
 * @Description
 * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
 *
 * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 *
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2022/1/17 18:55
 */

/*
根据题意可以知道：珂珂吃香蕉的速度越小，耗时越多。反之，速度越大，耗时越少，这是题目的 单调性；
我们要找的是速度。因为题目限制了珂珂一个小时之内只能选择一堆香蕉吃，因此速度最大值就是这几堆香蕉中，数量最多的那一堆。速度的最小值是 11，其实还可以再分析一下下界是多少，由于二分搜索的时间复杂度很低，严格的分析不是很有必要；
还是因为珂珂一个小时之内只能选择一堆香蕉吃，因此：每堆香蕉吃完的耗时 = 这堆香蕉的数量 / 珂珂一小时吃香蕉的数量。根据题意，这里的 / 在不能整除的时候，需要 上取整。

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/koko-eating-bananas/solution/er-fen-cha-zhao-ding-wei-su-du-by-liweiwei1419/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
// 关键点在于如果速度 k 吃不完所有香蕉，那么所有小于等于 k 的解都可以被排除。
public class Solution0875KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        // 解空间为 [1, max(piles)]
        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(pile, right);
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 速度为mid时，可以在h小时吃完，可以尝试更小的速度
            if (possible(piles, h, mid)) {
                right = mid - 1;
            }
            // 速度为mid时，吃不完，速度需要更大
            else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 是否能以 K 的进食速度在 H 小时内吃完所有的香蕉
    public boolean possible(int[] piles, int h, int K) {
        int time = 0;
        for (int pile : piles) {
            // pile/K 向上取整
            // 要向上取整，就是要在不影响除法结果正确的前提下，补充(加)一个尽可能大的数。这个数最大不能等于或超过Kd, 等于K除法结果就不正确了。所以就是speed - 1。
            time += (pile + (K - 1))/ K;
        }
        return time <= h;
    }
}
