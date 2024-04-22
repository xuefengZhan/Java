package dp.区间DP;

/**
 * @ClassName leetcode_375_猜数字大小II
 * @Author zxf
 * @Date 2023/9/14 11:38
 * @Questinon Describrition
 * 确保你获胜 的最小现金数
 **/
public class leetcode_375_猜数字大小II {

    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        return dfs(1,n);
    }

    private int dfs(int i , int j){
        if(i >= j) return 0;

        if(i == j - 1){
            return i;
        }

        if(dp[i][j] != 0) return dp[i][j];


        int res = Integer.MAX_VALUE;
        for (int x = i; x <= j; x++) {
           res = Math.min(res, x + Math.max(dfs(i,x-1) , dfs(x+1,j)));
        }


        dp[i][j] = res;
        return res;
    }
}
