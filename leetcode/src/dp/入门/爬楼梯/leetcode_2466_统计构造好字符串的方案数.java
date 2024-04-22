package dp.入门.爬楼梯;

/**
 * @ClassName leetcode_2466_统计构造好字符串的方案数
 * @Author zxf
 * @Date 2024/4/19 11:36
 * @Questinon Describrition
 **/
public class leetcode_2466_统计构造好字符串的方案数 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long res = 0;
        int mod = 1000000007;

        long[] dp = new long[high+1];

        dp[0] = 1;

        int min = Math.min(zero,one);

        for (int i = min; i <= high; i++) {
            if(i >= zero) dp[i] = ( dp[i] + dp[i-zero] ) % mod;
            if(i >= one) dp[i] = ( dp[i-one] + dp[i] ) % mod;

            if(i >= low){
                res  = (res + dp[i]) % mod;
            }
        }

        return (int) res;
    }
}
