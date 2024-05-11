package dp.No02_网格图dp;

/**
 * @ClassName leetcode_741_摘樱桃
 * @Author zxf
 * @Date 2024/5/11 17:27
 * @Questinon Describrition
 *
 * 两段最优 ！= 全局最优
 **/
public class leetcode_741_摘樱桃 {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;

        int t = (n-1) * (n-1); //单人总共要走的步数

        int[][][] dp = new int[t][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

        return -1;
    }
}
