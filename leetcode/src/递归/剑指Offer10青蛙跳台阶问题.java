package 递归;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 *
 * 100%
 */
public class 剑指Offer10青蛙跳台阶问题 {
    public int numWays(int n) {

        if(n==0 || n == 1) return 1;

        int[] dp = new int[n + 1];

        //todo 1.初始状态
        dp[0] = 1;
        dp[1] = 1;
        int i = 2;
        while(i <= n ){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            i++;
        }

        return dp[n] % 1000000007;
    }
}
