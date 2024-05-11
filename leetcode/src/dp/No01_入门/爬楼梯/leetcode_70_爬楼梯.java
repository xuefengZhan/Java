package dp.No01_入门.爬楼梯;

/**
 * @ClassName leetcode_70_爬楼梯
 * @Author zxf
 * @Date 2023/8/14 14:38
 * @Questinon Describrition
 **/
public class leetcode_70_爬楼梯 {
    public int climbStairs(int n) {
        if(n <= 2) return n;

        //1.定义状态
        //index：台阶数 自变量
        //dp[index] : 方法个数 因变量
        int[] dp = new int[n+1];

        //2.初始状态
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        //3.状态转移
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
