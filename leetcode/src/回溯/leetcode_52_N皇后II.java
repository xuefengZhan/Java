package 回溯;

/**
 * @ClassName leetcode_52_N皇后II
 * @Author zxf
 * @Date 2023/8/11 9:27
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量
 *
 * hard
 **/
public class leetcode_52_N皇后II {
    int[] cols;
    int res;

    public int totalNQueens(int n) {
        cols = new int[n];
        dfs(0,n);
        return res;
    }


    private boolean isValid(int row,int col){
        //这里在处理第一层 即row=0的时候，直接return true了 所以第一层都可以放置
        for (int i = 0; i < row; i++) {
            if(col == cols[i]) return false;
            if(Math.abs(col - cols[i]) == row - i) return false;
        }
        return true;
    }


    private void dfs(int row,int n){
        if(row==n){
            res++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isValid(row,i)){
                cols[row] = i;

                dfs(row+1,n);

                //cols[row] = 0;
            }
        }
    }


    public static void main(String[] args) {
        leetcode_52_N皇后II v = new leetcode_52_N皇后II();
        int i = v.totalNQueens(4);
        System.out.println(i);
    }
}
