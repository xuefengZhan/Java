package dp.No02_网格图dp;

import java.util.Arrays;

/**
 * @ClassName leetcode_931_下降路径最小和
 * @Author zxf
 * @Date 2023/10/24 18:55
 * @Questinon Describrition
 **/
public class leetcode_931_下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];

        dp[0] = matrix[0];

        //行
        for (int i = 1; i < n; i++) {
            System.out.println(Arrays.toString(dp[i - 1]));
            //列
            for (int j = 0; j < n; j++) {
                int a = j == 0 ? Integer.MAX_VALUE : dp[i-1][j-1];
                int b = dp[i-1][j];
                int c = j == n-1 ? Integer.MAX_VALUE : dp[i-1][j+1];

                dp[i][j] = Math.min(Math.min(a,b),c) + matrix[i][j];
            }
        }

        int res = dp[n-1][0];
        for (int i : dp[n-1]) {
            res = Math.min(i,res);
        }

        return res;
    }
}
