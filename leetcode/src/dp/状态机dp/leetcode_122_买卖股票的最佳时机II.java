package dp.状态机dp;

/**
 * @ClassName leetcode_122_买卖股票的最佳时机II
 * @Author zxf
 * @Date 2023/9/1 11:01
 * @Questinon Describrition
 **/
public class leetcode_122_买卖股票的最佳时机II {


    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        //0表示不持有
        //1表示持有
        dp[0][0] = 0;
        dp[0][1] = - prices[0];

        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i-1][0] - prices[i],dp[i-1][1]); //当天买入
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
        }
        return dp[n-1][0];
    }
    public static void main(String[] args) {
        leetcode_122_买卖股票的最佳时机II vv = new leetcode_122_买卖股票的最佳时机II();

        int[] prices = {7,1,5,3,6,4};

        int i = vv.maxProfit(prices);


        System.out.println(i);
    }
}
