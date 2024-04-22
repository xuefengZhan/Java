package dp.入门.爬楼梯;

/**
 * @ClassName leetcode_746_使用最小花费爬楼梯
 * @Author zxf
 * @Date 2023/8/15 10:29
 * @Questinon Describrition
 **/
public class leetcode_746_使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        //初始化  0和1阶台阶免费上
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<=n;i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }
}
