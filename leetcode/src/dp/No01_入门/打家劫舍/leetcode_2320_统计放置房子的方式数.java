package dp.No01_入门.打家劫舍;

/**
 * @ClassName leetcode_2320_统计放置房子的方式数
 * @Author zxf
 * @Date 2024/4/22 17:34
 * @Questinon Describrition
 **/
public class leetcode_2320_统计放置房子的方式数 {
    public int countHousePlacements(int n) {
        int m = Math.max(n,2);
        long[] dp = new long[m+1];

        dp[0] = 1;
        dp[1] = 2; //只考虑第一个位置 只有摆和不摆两种
        dp[2] = 3; //前两个位置：都不摆(1)、摆一个(2)

        int mod = 1000000007;

        for(int i = 3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % mod;
        }

        return (int) ( (dp[n] * dp[n]) % mod );
    }
}
