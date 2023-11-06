package dfs;

import java.util.Arrays;

/**
 * @ClassName leetcode_329_矩阵中的最长递增路径
 * @Author zxf
 * @Date 2023/9/25 15:45
 * @Questinon Describrition
 *
 * 10ms   dfs + 记忆化搜索
 **/
public class leetcode_329_矩阵中的最长递增路径 {
    int[][] visited;

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        visited = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res,dfs(matrix,i,j));
            }
        }

        return res;

    }


    private int dfs(int[][] matrix,int m , int n){

        if(m < 0 || m >= matrix.length || n < 0 || n >= matrix[0].length){
            return 0;
        }

        if(visited[m][n] != 0) return visited[m][n];

        int now = matrix[m][n];

        int provided = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if(i == j || i == -j) continue;

                int row = m + i;
                int col = n + j;

                if( row >= 0 && row < matrix.length &&  col >= 0 &&  col < matrix[0].length && now >= matrix[row][col]){
                    //比现在的小 供0
                    continue;
                }

                //越界 供0
                provided = Math.max(dfs(matrix,row,col) ,provided) ;

            }
        }

        visited[m][n] = provided + 1;


        return visited[m][n];
    }

    public static void main(String[] args) {
        leetcode_329_矩阵中的最长递增路径 v = new leetcode_329_矩阵中的最长递增路径();

        int[][] martix = {{3,4,5},{3,2,6},{2,2,1}};

        int i = v.longestIncreasingPath(martix);

        System.out.println(i);
    }
}
