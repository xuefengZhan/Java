package dp.状态机dp;

/**
 * @ClassName leetcode_714_买卖股票得最佳时机含手续费
 * @Author zxf
 * @Date 2023/11/21 18:55
 * @Questinon Describrition
 **/
public class leetcode_714_买卖股票得最佳时机含手续费 {
    int[][] dp ;
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        dp = new int[n][2];

        //每天有持有股票和不持有股票两种状态
        dp[0][0] = 0;
        dp[0][1] = - prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i] - fee) ; //卖出
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }


        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
}
