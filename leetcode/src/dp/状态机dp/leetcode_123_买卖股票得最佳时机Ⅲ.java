package dp.状态机dp;

import java.util.Arrays;

/**
 * @ClassName leetcode_123_买卖股票得最佳时机Ⅲ
 * @Author zxf
 * @Date 2023/11/21 19:12
 * @Questinon Describrition
 **/
public class leetcode_123_买卖股票得最佳时机Ⅲ {

    int[][] dp ;
    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new int[n][2];

        //每天有持有股票和不持有股票两种状态
        dp[0][0] = 0;
        dp[0][1] = - prices[0];

        int max = 0;
        int second = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]); //卖出
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);


            //发生了一次卖出  dp[i][x] 都是累计最大值
            if(dp[i][0] > dp[i-1][0]){
                //本次卖出利润
                int tmp = dp[i][0] - dp[i-1][0];
                if(tmp > max){
                    second = max;
                    max = tmp;
                }  else if(dp[i][0] > second){
                    second = tmp;
                }
            }
        }


        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return max + second;
    }
}
