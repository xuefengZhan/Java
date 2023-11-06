package dp.路径问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_931_下降路径最小和
 * @Author zxf
 * @Date 2023/10/24 18:55
 * @Questinon Describrition
 **/
public class leetcode_931_下降路径最小和 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        int res1 = Integer.MAX_VALUE;
        int res2 = Integer.MAX_VALUE;


        //初始化
        for (int i = 0; i < n; i++) {
            dp1[i] = matrix[0][i];
            res1 = Math.min(res1,dp1[i]);
        }

        for (int i = 1; i < n; i++) {
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if(j + 1 < n ){
                    right = dp1[j+1];
                }
                if(j > 0){
                    left = dp1[j-1] ;
                }

                int min = Math.min(Math.min(left,dp1[j]),right);

                dp2[j] = min + matrix[i][j];
                if(i == n - 1){
                    res2 = Math.min(res2,dp2[j]);
                }
            }

            dp1 = dp2;
            dp2 = new int[n];
        }

        return n == 1 ? res1 : res2;
    }
}
