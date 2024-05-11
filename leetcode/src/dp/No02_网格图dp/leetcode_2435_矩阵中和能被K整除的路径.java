package dp.No02_网格图dp;

/**
 * @ClassName leetcode_2435_矩阵中和能被K整除的路径
 * @Author zxf
 * @Date 2024/5/9 9:52
 * @Questinon Describrition
 **/
public class leetcode_2435_矩阵中和能被K整除的路径 {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int mod = 1000000007;

        int[][][] dp = new int[m][n][k];  //到达i,j 且路径和 % mod = v 的路径数
        //初始化
        int init = grid[0][0] % k;
        dp[0][0][init] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int v = 0; v < k; v++) {

                    int cur = (v + grid[i][j]) % k ;
                    //左边
                    if(j > 0){
                        dp[i][j][cur] = (dp[i][j][cur] + dp[i][j-1][v]) % mod;
                    }
                    if(i > 0){
                        dp[i][j][cur] = (dp[i][j][cur] + dp[i-1][j][v]) % mod;
                    }
                }
            }
        }

        return dp[m-1][n-1][0];
    }
}
