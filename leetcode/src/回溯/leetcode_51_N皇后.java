package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_51_N皇后
 * @Author zxf
 * @Date 2023/8/10 18:42
 **/
public class leetcode_51_N皇后 {
    List<List<String>> res = new ArrayList<>();
    int[] cols;

    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return null;
        cols = new int[n];

        dfs(0,n,new ArrayList<String>());
        return res;

    }


    private void dfs(int row,int n,List<String> path){
        if(row == n){
            res.add(new ArrayList<>(path));
            return;
        }

        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = '.';
        }

        //i是col
        for (int i = 0; i < n; i++) {
            //todo 剪支
            if(isValid(row,i)){
                chars[i] = 'Q';
                path.add(new String(chars));
                cols[row] = i;

                dfs(row+1,n,path);

                chars[i] = '.';
                path.remove(path.size() - 1);
                //cols[row] = 0;
            }
        }
    }


    private boolean isValid(int row,int col){
        //这里在处理第一层 即row=0的时候，直接return true了 所以第一层都可以放置
        for (int i = 0; i < row; i++) {
            if(col == cols[i]) return false;
            if(Math.abs(col - cols[i]) == row - i) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        leetcode_51_N皇后  v = new leetcode_51_N皇后();
        List<List<String>> lists = v.solveNQueens(4);
        System.out.println(lists);
    }
}
