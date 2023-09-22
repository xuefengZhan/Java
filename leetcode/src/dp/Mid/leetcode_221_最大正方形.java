package dp.Mid;

import java.util.Arrays;

/**
 * @ClassName leetcode_221_最大正方形
 * @Author zxf
 * @Date 2023/8/30 11:40
 * @Questinon Describrition
 *
 * 7ms
 **/
public class leetcode_221_最大正方形 {

    /**
     * 二维数组
     * @param matrix
     * @return
     */
//    public int maximalSquare(char[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        int[][] dp = new int[m][n];
//
//        //初始化
//        int res = Integer.MIN_VALUE;
//        for (int i = 0; i < m; i++) {
//            dp[i][0] = matrix[i][0] == '0' ? 0 : 1 ;
//            res = Math.max(res,dp[i][0]);
//        }
//
//        for (int i = 0; i < n; i++) {
//            dp[0][i] = matrix[0][i] == '0' ? 0 : 1 ;
//            res = Math.max(res,dp[0][i]);
//        }
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 1; j < n; j++) {
//                if(matrix[i][j] == '0') dp[i][j] = 0;
//                else{
//                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1],dp[i-1][j-1]),dp[i-1][j]);
//                }
//
//                res = Math.max(res,dp[i][j]);
//            }
//        }
//
//        for (int[] ints : dp) {
//            System.out.println(Arrays.toString(ints));
//        }
//
//        return res * res;
//    }

//   记忆化搜索 10ms

    int res = 0;
    int[][] dp;
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints,300);
        }
        dfs(matrix,m-1,n-1);

        return res * res;
    }


    private int dfs(char[][] matrix,int i ,int j){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != 300) return dp[i][j];


        int left = dfs(matrix,i,j-1);
        int top = dfs(matrix,i-1,j);
        int leftTop = dfs(matrix,i-1,j-1);
        if(matrix[i][j] == '0') {
            dp[i][j] = 0;
        }else {
            dp[i][j] = Math.min(Math.min(left, top), leftTop) + 1;
        }

        res = Math.max(res,dp[i][j]);
        return dp[i][j];
    }


    public static void main(String[] args) {
        leetcode_221_最大正方形 v = new leetcode_221_最大正方形();
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int res = v.maximalSquare(matrix);

        System.out.println(res);
    }
}
