package dp.No02_网格图dp;

/**
 * @ClassName LCR_166_珠宝的最高价值
 * @Author zxf
 * @Date 2024/4/29 15:47
 * @Questinon Describrition
 *
 *   这题和 64_最小路径和  一模一样
 **/
public class LCR_166_珠宝的最高价值 {
    public int jewelleryValue(int[][] frame) {

        int m = frame.length;
        int n = frame[0].length;

        //初始化dp数组
        int[] dp = new int[n];
        dp[0] = frame[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = frame[0][i] + dp[i-1];
        }



        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0){
                    dp[j] = dp[j] + frame[i][j];
                }else{
                    dp[j] = Math.max(dp[j-1],dp[j]) + frame[i][j];
                }
            }
        }

        return dp[n-1];
    }
}
