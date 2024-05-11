package dp.No02_网格图dp;

/**
 * @ClassName leetcode_2304_网格中的最小路径代价
 * @Author zxf
 * @Date 2024/5/8 13:46
 * @Questinon Describrition
 **/
public class leetcode_2304_网格中的最小路径代价 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0] = grid[0];

        for (int i = 1; i < m; i++) {

            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
                int cost = 50000;
                for (int k = 0; k < n; k++) {
                    //上一层的价值
                    int index = grid[i-1][k];
                    cost = Math.min(dp[i-1][k] + moveCost[index][j],cost);
                }
                dp[i][j] += cost;
            }
        }
        // for (int[] ints : dp) {
        //     System.out.println(Arrays.toString(ints));
        // }
        int res = 50000;
        for (int i : dp[m - 1]) {
            res = Math.min(res,i);
        }
        return res;
    }
}
