package dfs;

import java.util.Arrays;

/**
 * @ClassName leetcode_130_被围绕的区域
 * @Author zxf
 * @Date 2023/10/8 18:19
 * @Questinon Describrition
 **/
public class leetcode_130_被围绕的区域 {

    boolean[][] visited;

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(board,i,0);
            dfs(board,i,cols-1);
        }

        for (int i = 1; i < cols - 1; i++) {
            dfs(board,0,i);
            dfs(board,rows-1,i);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(!visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }


    private void dfs(char[][] board,int row,int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == 'X' || visited[row][col]) return;


        visited[row][col] = true;

        dfs(board,row+1,col);
        dfs(board,row-1,col);
        dfs(board,row,col+1);
        dfs(board,row,col-1);
    }
}
