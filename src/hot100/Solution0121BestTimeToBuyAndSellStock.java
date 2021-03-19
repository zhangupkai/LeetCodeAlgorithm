package hot100;

/**
 * @Description
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Kai
 * @Date 2021/3/18 20:28
 */
public class Solution0121BestTimeToBuyAndSellStock {
    // 简化版dp，类比第53题
    public int maxProfit(int[] prices) {
        int ans = 0; // 最大利润
        int pre = 0; // i-1天结束时的最大利润
        for (int i = 1; i < prices.length; ++i) {
            // i天结束时与i-1天结束时的利润差值
            int diff = prices[i] - prices[i - 1];
            // i天的最大利润 = i-1天的最大利益 + 这两天的利润差
            pre = Math.max(pre + diff, 0); // 利润大于0才保留
            ans = Math.max(pre, ans);
        }

        return ans;
    }

    // 股票类题目通用dp
    public int maxProfitGeneral(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        // i这一天结束时 持股状态为j（0 不持股，1 持股）
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[len - 1][0];
    }
}
