package dp.No02_网格图dp;

/**
 * @ClassName leetcode_174_地下城游戏
 * @Author zxf
 * @Date 2024/5/9 10:42
 * @Questinon Describrition
 *
 * 题意分析：
 *  这题本质上是找从[0,0]到[m-1,n-1]通路中（每条路径 过程中最大的负数）
 **/
public class leetcode_174_地下城游戏 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        dp[m-1][n-1] = Math.min(dungeon[m - 1][n - 1], 0);

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                if(i == m - 1 && j == n - 1) continue;

                int cur = Integer.MIN_VALUE;

                if(i < m-1){
                    cur = dp[i+1][j] + dungeon[i][j];
                }

                if(j < n-1){
                    cur = Math.max(cur,dp[i][j+1] + dungeon[i][j]);
                }

                if(cur >= 0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = cur;
                }
            }
        }

        // for (int[] ints : dp) {
        //     System.out.println(Arrays.toString(ints));
        // }
        if(dp[0][0] > 0) return 0;
        return 1 - dp[0][0];
    }
}
