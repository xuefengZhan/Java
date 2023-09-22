package dp.Easy;

/**
 * @ClassName LCS01_下载插件
 * @Author zxf
 * @Date 2023/8/21 11:50
 * @Questinon Describrition
 **/
public class LCS01_下载插件 {
    public int leastMinutes(int n) {
        if(n == 1) return 1;

        int[] dp = new int[n + 1];

        dp[1] = 1;


        //dp[i]的来源有两个：
        //1. 不提升下载速度，dp[i - 1] + 1
        //2. 下载量只有当前一半的时候，下载速度为i/2 也就是 dp[i/2] + 1
        //        3  dp[2] + 1   下载速度必须>= i / 2
        //        4  dp[2] + 1
        //        5  dp[3] + 1
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i-1] + 1,dp[(i + 1) / 2] + 1);
        }

        return dp[n];
    }
}
