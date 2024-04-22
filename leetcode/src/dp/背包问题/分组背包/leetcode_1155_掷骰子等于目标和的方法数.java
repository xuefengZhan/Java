package dp.背包问题.分组背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_1155_掷骰子等于目标和的方法数
 * @Author zxf
 * @Date 2024/4/16 9:47
 * @Questinon Describrition
 **/
public class leetcode_1155_掷骰子等于目标和的方法数 {
    public int numRollsToTarget(int n, int k, int target) {
        // tareget 不在范围内
        if(target < n || target > n * k) return 0;

        int mod = 1000000007;

        //选择次数 目标和
        long[] dp = new long[target+1];

        //初始化 -1表示凑不到该和
        Arrays.fill(dp,-1);
        dp[0] = 1;  //一个都不选 和为0的时候正好有一个方案


        //次数
        for (int i = 1; i <= n; i++) {
            //每一次可以从j-x过来
            for (int x = 1; x <= k; x++) {
                //和
                for (int j = target; j >= x; j++) {
                    if(dp[j-x] != -1){
                        dp[j] = (dp[j] + dp[j-x]) % mod;
                    }
                }
            }
        }

        //一定是第n次
        return (int) dp[target];
    }
}
