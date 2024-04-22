package dp.递推;

/**
 * @ClassName dp.递推.leetcode_279_完全平方数
 * @Author zxf
 * @Date 2024/3/12 10:06
 * @Questinon Describrition
 **/
public class leetcode_279_完全平方数 {
    public int numSquares(int n) {
        int[] dp = new int[n+1]; //i表示数字i dp[i]表示整数i 完全平方数最少数量

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j * j < i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1 , dp[i]);
            }
        }

        return dp[n];
    }
}
