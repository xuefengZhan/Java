package dp.路径问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_64_最小路径和
 * @Author zxf
 * @Date 2023/8/24 11:38
 * @Questinon Describrition
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 **/
public class leetcode_64_最小路径和 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        //初始化dp数组
        dp[0][0] = grid[0][0];
        //第一列
        for (int i = 1; i < m ;i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        //第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j] , dp[i][j-1]) + grid[i][j];
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        leetcode_64_最小路径和 v = new leetcode_64_最小路径和();

        int res = v.minPathSum(grid);

        System.out.println(res);
    }
}
