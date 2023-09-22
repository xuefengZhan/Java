package dfs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode934_最短的桥 {
    public int shortestBridge(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    Queue<int[]> que = new LinkedList<>();
                    dfs(grid,i,j,que);

                    //标识层级
                    int level = 0;

                    while(! que.isEmpty()){
                        //todo  遍历当前层
                        int levelSize = que.size();
                        for(int n = 0;n<levelSize;n++){
                            int[] poll = que.poll();
                            int row = poll[0];
                            int col = poll[1];

                            for(int r = -1;r < 2;r++){
                                for(int c = -1;c<2;c++){
                                    if(r == c || r == -c){
                                        continue;
                                    }

                                    int nr = row + r;
                                    int nc = col + c;

                                    if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length){
                                        continue;
                                    }

                                    if(grid[nr][nc] == 0){
                                        grid[nr][nc] = -1;
                                        que.offer(new int[]{nr,nc});
                                    }else if(grid[nr][nc] == 1){
                                        return level;
                                    }
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        return 0;
    }



    private void dfs(int[][] grid,int i,int j,Queue<int[]> que){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1){
            return ;
        }

        grid[i][j] = -1;
        que.offer(new int[]{i,j});

        dfs(grid,i-1,j,que);
        dfs(grid,i+1,j,que);
        dfs(grid,i,j-1,que);
        dfs(grid,i,j+1,que);
    }






    public static void main(String[] args) {
        leetcode934_最短的桥 v = new leetcode934_最短的桥();
        //int[][] grid = new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        int[][] grid = new int[][]{{0,1},{1,0}};
        int i = v.shortestBridge(grid);
        System.out.println(i);
    }
}
