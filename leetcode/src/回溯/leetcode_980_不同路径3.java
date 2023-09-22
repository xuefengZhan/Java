package 回溯;

/**
 * @ClassName leetcode_不同路径3
 * @Author zxf
 * @Date 2023/2/7 13:07
 *
 *执行用时：1 ms , 在所有 Java 提交中击败了 40.64% 的用户
 *内存消耗：39.7 MB, 在所有 Java 提交中击败了18.33% 的用户
 * 通过测试用例：
 * 39 / 39
 *
 **/
public class leetcode_980_不同路径3 {
    int max = 0;  //记录0的个数
    int res = 0;

    //记录起始坐标
    int sx = 0;
    int sy = 0;

    //终点坐标
    int ex = 0;
    int ey = 0;
    public int uniquePathsIII(int[][] grid) {
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                int x = grid[i][j];

                if(x == 0) max++;
                if(x == 1){
                    sx = i;
                    sy = j;
                }
                if(x == 2){
                    ex = i;
                    ey = j;
                }
            }
        }

        dfs(grid, sx,sy,0);
        return res;
    }

    private void dfs(int[][] grid,int row,int col,int size){
        if(row == ex &&  col == ey){
            if(size == max + 1){
                res++;
            }
            return;
        }

        //准备可选路径
        int[] pathX = {0,1,0,-1};
        int[] pathY = {1,0,-1,0};

        for(int i = 0;i<4;i++){

            int nextRow = row + pathX[i];
            int nextCol = col + pathY[i];

            if(nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length || grid[nextRow][nextCol] == 3 || grid[nextRow][nextCol] == -1 || grid[nextRow][nextCol] == 1) continue;

            grid[nextRow][nextCol] = 3;
            dfs(grid,nextRow,nextCol,size+1);
            grid[nextRow][nextCol] = 0;
        }
    }
}
