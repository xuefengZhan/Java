package dp.No02_网格图dp;

/**
 * @ClassName leetcode_64_最小路径和
 * @Author zxf
 * @Date 2023/8/24 11:38
 * @Questinon Describrition
 *
 * 这题和LCR_166_珠宝的最高价值 一模一样
 **/
public class leetcode_64_最小路径和 {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        //初始化dp数组
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = grid[0][i] + dp[i-1];
        }



        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0){
                    dp[j] = dp[j] + grid[i][j];
                }else{
                    dp[j] = Math.min(dp[j-1],dp[j]) + grid[i][j];
                }
            }
        }

        return dp[n-1];
    }


    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        leetcode_64_最小路径和 v = new leetcode_64_最小路径和();

        int res = v.minPathSum(grid);

        System.out.println(res);
    }
}
