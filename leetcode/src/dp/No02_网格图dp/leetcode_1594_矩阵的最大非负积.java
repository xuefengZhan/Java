package dp.No02_网格图dp;

/**
 * @ClassName leetcode_1594_矩阵的最大非负积
 * @Author zxf
 * @Date 2024/5/8 14:45
 * @Questinon Describrition
 *
 * 进阶
 **/
public class leetcode_1594_矩阵的最大非负积 {
/**    DFS解法 暴力穷举
 *     int m = 0;
 *     int n = 0;
 *     long res = -1;
 *
 *     int mod = 1000000007;
 *
 *     public int maxProductPath(int[][] grid) {
 *         m = grid.length;
 *         n = grid[0].length;
 *
 *         dfs(grid,1,0,0);
 *
 *         if(res < 0) return -1;
 *         return (int) res % mod;
 *     }
 *
 *
 *     //回溯法
 *     private void dfs(int[][] grid, long tmp , int row,int col){
 *         //边界
 *         if(row >= m || col >= n) return;
 *
 *         //剪枝
 *         if(grid[row][col] == 0){
 *             res = Math.max(res,0);
 *             return;
 *         }
 *
 *
 *         tmp = tmp * grid[row][col];
 *
 *         if(row == m-1 && col == n-1){
 *             res = Math.max(res,tmp);
 *             return;
 *         }
 *
 *         //当下选择
 *         dfs(grid,tmp,row+1,col);
 *         dfs(grid,tmp,row,col+1);
 *     }
 */


public int maxProductPath(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int mod = 1000000007;

    long[][] maxs = new long[m][n];
    long[][] mins = new long[m][n];

    for (int i = 0; i < m; i++) {
        maxs[i][0] = i > 0 ? maxs[i-1][0] * grid[i][0] : grid[i][0];
        mins[i][0] = i > 0 ? mins[i-1][0] * grid[i][0] : grid[i][0];
    }

    for (int i = 1; i < n; i++) {
        maxs[0][i] = maxs[0][i-1] * grid[0][i];
        mins[0][i] = mins[0][i-1] * grid[0][i];
    }

    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {

            long leftMax = maxs[i][j-1];
            long leftMin = mins[i][j-1];

            long upMax =  maxs[i-1][j] ;
            long upMin =  mins[i-1][j] ;

            // System.out.println("grid[i][j] == " + grid[i][j]);

            if(grid[i][j] < 0){
                maxs[i][j] = Math.min(leftMin,upMin) * grid[i][j];
                mins[i][j] = Math.max(leftMax,upMax) * grid[i][j];
            }else{
                maxs[i][j] = Math.max(leftMax,upMax) * grid[i][j];
                mins[i][j] = Math.min(leftMin,upMin) * grid[i][j];
            }
        }
    }

    // for (long[] min : mins) {
    //     System.out.println(Arrays.toString(min));
    // }

    // System.out.println("----------------------------");
    // for (long[] max : maxs) {
    //     System.out.println(Arrays.toString(max));
    // }

    return maxs[m-1][n-1] < 0 ? -1 : (int) (maxs[m-1][n-1] % mod);
}


}
