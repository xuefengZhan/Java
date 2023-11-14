package dp.股票买卖;

import java.util.Arrays;

/**
 * @ClassName leetcode_309_买卖股票的最佳时机含冷冻期
 * @Author zxf
 * @Date 2023/8/31 14:01
 * @Questinon Describrition
 *
 * 题解：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/solutions/181734/fei-zhuang-tai-ji-de-dpjiang-jie-chao-ji-tong-su-y/
 **/
public class leetcode_309_买卖股票的最佳时机含冷冻期 {

//    public int maxProfit(int[] prices) {
//        int[][] dp = new int[prices.length][2];
//
//        //0 表示当天不持股
//        //1 表示当天持股
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//        for (int i = 1; i < dp.length; i++) {
//            dp[i][0] = Math.max(dp[i-1][1] + prices[i],dp[i-1][0]);
//            dp[i][1] = Math.max(dp[i-1][1] , i== 1 ? 0 : dp[i - 2][0] - prices[i]);
//        }
//
//
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
//        return dp[prices.length-1][0];
//    }


    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];

        //0 表示当天不持股（不卖出）
        //1 表示当天持股
        //2 表示当天不持股 （卖出导致进入冷冻期）

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = Integer.MIN_VALUE;

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i],dp[i-1][1]);
            dp[i][2] = dp[i-1][1] + prices[i];
        }


        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][2]);
    }



    public static void main(String[] args) {
        leetcode_309_买卖股票的最佳时机含冷冻期 v = new leetcode_309_买卖股票的最佳时机含冷冻期();

        int[] prices = {1,2,3,0,2};

        int res = v.maxProfit(prices);

        System.out.println(res);
    }
}
