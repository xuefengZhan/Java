package dfs;

/**
 * @ClassName leetcode_200_岛屿数量
 * @Author zxf
 * @Date 2023/3/2 16:12
 *
 *
 * mid  100
 **/
public class leetcode_200_岛屿数量 {
    public int numIslands(char[][] grid) {

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){
                    dfs(grid,i,j,grid.length,grid[i].length);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid,int i ,int j ,int rows,int cols){
        if(i<0 || i >= rows || j < 0 || j >= cols || grid[i][j] != '1'){
            return ;
        }

        grid[i][j] = '2';

        dfs(grid,i-1,j,rows,cols);
        dfs(grid,i+1,j,rows,cols);
        dfs(grid,i,j-1,rows,cols);
        dfs(grid,i,j+1,rows,cols);
    }
}
