package dp.No02_网格图dp;

/**
 * @ClassName leetcode_1289_下降路径最小和II
 * @Author zxf
 * @Date 2023/8/10 13:41
 *
 * v1
 *
 * 84ms
 * 击败 24.21%使用 Java 的用户
 **/
public class leetcode_1289_下降路径最小和II_v1 {
    public int minFallingPathSum(int[][] grid) {

        //初始化dp数组
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(i == 0){
                    dp[i][j] = grid[i][j];
                }else{
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }



        //动态转移
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {

                int minIndex = 0;
                int minValue = Integer.MAX_VALUE;
                int secondMinValue = Integer.MAX_VALUE;


                for (int k = 0; k < grid.length; k++) {
                    if(dp[i-1][k] < minValue){
                        minIndex = k;
                        minValue = dp[i-1][k];
                    }
                }

                for (int k = 0; k < grid.length; k++) {
                    if(dp[i-1][k] <= secondMinValue && dp[i-1][k] >= minValue){
                        if(k == minIndex) continue;
                        secondMinValue = dp[i-1][k];
                    }
                }

                if(j == minIndex){
                    dp[i][j] = secondMinValue + grid[i][j];
                }else{
                    dp[i][j] = minValue + grid[i][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            res = Math.min(res,dp[grid.length - 1][i]);
        }

        //System.out.println(Arrays.deepToString(dp));
        return res;
    }
}
