package dp.背包问题.零一背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_2787_将一个数字表示成幂的和的方案书
 * @Author zxf
 * @Date 2024/4/1 10:10
 * @Questinon Describrition
 **/
public class leetcode_2787_将一个数字表示成幂的和的方案数 {
    public int numberOfWays(int n, int x) {
        long[] dp = new long[n+1];
        int mod = 1000000007;

        //和为1只有一种方案
        dp[0] = 1;
        //j为索引
        for (int j = 1; j <= n ; j++) {
            long cur = power(j,x);
            //i为和
            for (int i = n; i >= cur; i--) {
                dp[i] =  (dp[i] + dp[ (int) (i - cur) ]) % mod;
            }
        }
        return (int) dp[n];
    }


    private long power(int a,int b){
        long res = a;
        for (int m = 1; m < b; m++) {
            res *= a;
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode_2787_将一个数字表示成幂的和的方案数 v = new leetcode_2787_将一个数字表示成幂的和的方案数();

        int n = 4;
        int x = 1;

        int res = v.numberOfWays(n, x);

        System.out.println(res);
    }
}
