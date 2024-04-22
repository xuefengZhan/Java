package dp.背包问题.完全背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_279_完全平方数
 * @Author zxf
 * @Date 2024/4/11 17:36
 * @Questinon Describrition
 **/
public class leetcode_279_完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int x = i * i;

            for (int j = x; j <= n; j++) {
                if(dp[j-x] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j-x]+1,dp[j]);
                }
            }
        }

        return dp[n];
    }
}
