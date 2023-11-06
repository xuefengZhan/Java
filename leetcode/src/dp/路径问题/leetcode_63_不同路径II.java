package dp.路径问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_63_不同路径II
 * @Author zxf
 * @Date 2023/10/24 15:23
 * @Questinon Describrition
 **/
public class leetcode_63_不同路径II {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[0][0] == 1) return 0;


        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];

        dp[0] = 1;
        //初始化
        for (int i = 1; i < n; i++) {
            if(obstacleGrid[0][i] == 1){
                dp[i] = 0;
            }else{
                dp[i] = dp[i-1];
            }
        }


        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] ==1){
                    dp[j] = 0;
                }else{
                    dp[j] = j >= 1 ? dp[j-1] + dp[j] : dp[j] ;
                }
            }
        }

        return dp[n-1];
    }
}
