package dp.背包问题.零一背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_879_盈利计划
 * @Author zxf
 * @Date 2024/4/2 11:21
 * @Questinon Describrition
 **/
public class leetcode_879_盈利计划 {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {


        long[][] dp = new long[minProfit+1][n+1];

        dp[0][0] = 1;

        int mod = 1000000007;



        int m ,p;

        //j是当前工作选项
        for (int j = 0; j < group.length; j++) {
            m = profit[j];
            p = group[j];

            //i是最小利润

            //todo .利润至少为i
            // 下面的循环条件中 k >= p ,i >= 0
            // 因为对于当前工作m,p来说，选择的话 人数k肯定要大于等于p
            // 如果m > i 也是满足条件的,因此不需要要求i >= m
            // dp[Math.max(i-m,0)][k-p]
            // 如果m > i ，那么i满足从 i - m 转移过来，但是i - m < 0
            // so 可以将负数全部放在0上 同时0 也满足 利润至少为0
            //

            for (int i = minProfit; i >= 0; i--) {
                //k是人数
                for (int k = n; k >= p; k--) {
                    //如果当前工作的利润大于i 可以加上
                    dp[i][k] = (dp[i][k] + dp[Math.max(i-m,0)][k-p]) % mod;
                }
            }
        }

        long res = 0;
        long[] longs = dp[minProfit];
        for (long aLong : longs) {
            res = (res + aLong) % mod;
        }

        return (int) res;
    }


}
