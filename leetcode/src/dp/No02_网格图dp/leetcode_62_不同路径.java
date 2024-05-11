package dp.No02_网格图dp;

import java.util.Arrays;

/**
 * @ClassName leetode_62_不同路径
 * @Author zxf
 * @Date 2024/5/6 14:55
 * @Questinon Describrition
 **/
public class leetcode_62_不同路径 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0) continue;
                dp[j] = dp[j-1] + dp[j];
            }
        }

        return dp[n-1];

    }
}
