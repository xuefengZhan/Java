package dp.Easy;

import java.util.Arrays;

/**
 * @ClassName leetcode_121_买卖股票的最佳时机
 * @Author zxf
 * @Date 2023/8/14 14:48
 * @Questinon Describrition
 *
 * 最值，需要获取以前状态的最值
 **/
public class leetcode_121_买卖股票的最佳时机 {
//    public int maxProfit(int[] prices) {
//        int res = 0;
//
//        //todo 1.定义状态 dp[i] i表示第i天 dp[i]表示当天的最大利润
//        //int[] dp = new int[prices.length];
//
//
//        //todo 2.状态转移方程
//        //dp[i] 为 prices[i] - min(prices[j])  j <= i
//        int min = prices[0];
//
//        for (int i = 0; i < prices.length; i++) {
//            min = Math.min(min,prices[i]);
//            res = Math.max(prices[i] - min,res);
//        }
//
//        return res;
//    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i-1][0] - prices[i] , dp[i-1][1]);
            dp[i][1] = Math.max(- prices[i] , dp[i-1][1]);

        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        leetcode_121_买卖股票的最佳时机 v = new leetcode_121_买卖股票的最佳时机();
        int[] prices = {7,1,5,3,6,4};

        int res = v.maxProfit(prices);

        System.out.println(res);
    }
}


