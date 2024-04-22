package dp.状态机dp;

import java.util.Arrays;

/**
 * @ClassName leetcode_188_买卖股票的最佳时机IV
 * @Author zxf
 * @Date 2023/11/22 15:03
 * @Questinon Describrition
 **/
public class leetcode_188_买卖股票的最佳时机IV {


//    int[] prices;
//    int[][] dp;
//
//
//    public int maxProfit(int k, int[] prices) {
//        int n = prices.length;
//        dp = new int[n][2];
//        this.prices = prices;
//        k = Math.min(k, n / 2);
//        return dfs(k,n-1,false);
//    }
//
//    private int dfs(int k , int i,boolean hold){
//
//
//
//        if(k < 0) return Integer.MIN_VALUE;
//        if(i < 0){
//            if(hold) return Integer.MIN_VALUE;
//            else return 0;
//        }
//
//
//
//        if(hold) {
//            dp[i][1] = Math.max(dfs(k,i-1,false) - prices[i],dfs(k,i-1,true));
//            return dp[i][1]; //当天买入
//        }
//
//        dp[i][0] = Math.max(dfs(k,i-1,false),dfs(k-1,i-1,true) + prices[i]);
//        return  dp[i][0];
//    }


    /**
     *  记忆化搜索
     */
//    int[] prices;
//
//    //用包装类 方便判断 是否可用  ！= null 即没值
//    Integer[][][] dp;
//
//
//    public int maxProfit(int k, int[] prices) {
//        int n = prices.length;
//
//        k = Math.min(k, n / 2);
//
//        dp = new Integer[k][n+1][2];
//
//        System.out.println(Arrays.deepToString(dp));
//        this.prices = prices;
//
//        return dfs(k,n-1,0);
//    }
//
//    //k 交易次数 i是天 hold 0 未持有 1 持有
//    private int dfs(int k , int i,int hold){
//
//        System.out.println("k == " + k);
//        System.out.println("i == " + i);
//        System.out.println("hold == " + hold);
//        //k小于0是 不合法的  求最大值 所以这里给个最小
//        if(k < 0) return Integer.MIN_VALUE;
//        //第一天
//        if(i < 0){
//            //第一天持股 返回
//            if(hold == 1){
//                dp[k][0][1] =  -prices[0];
//                return -prices[0];
//            }else{
//                // 第一天不持股返回0
//                dp[k][0][0] =  0;
//                return 0;
//            }
//        }
//
//        if (dp[k][i][hold] != null) {
//            return dp[k][i][hold];
//        }
//
//        int res = 0;
//
//        if(hold == 1) {
//            res = Math.max(dfs(k,i-1,0) - prices[i],dfs(k,i-1,1));
//
//        }else{
//            res = Math.max(dfs(k,i-1,0),dfs(k-1,i-1,1) + prices[i]);
//        }
//
//
//        return  dp[k][i][hold] = res;
//    }



    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp =  new int[k+1][n][2];

        //边界条件
        //1.第一天
        dp[0][0][0] = 0;
        dp[0][0][1] = -prices[0];

        for (int i = 1; i <= k; i++) {
            dp[i][0][0] = -1000000;
            dp[i][0][1] = -1000000;
        }

        int res = 0;

        for (int i = 1; i < n; i++) {
            //无交易
            dp[0][i][1] = Math.max(dp[0][i-1][1],dp[0][i-1][0] - prices[i]);
            //天数
            for (int j = 1; j <= k; j++) {
                //交易次数
                if(j > (i+1)/2){
                    dp[j][i][0] = -1000000;
                    dp[j][i][1] = -1000000;
                }else{
                    dp[j][i][0] = Math.max(dp[j][i-1][0],dp[j-1][i-1][1] + prices[i]); // 卖出
                    dp[j][i][1] = Math.max(dp[j][i-1][1],dp[j][i-1][0] - prices[i]); // 买入
                }
                res = Math.max(dp[j][i][0],res);
            }
        }

        return res;

    }



    public static void main(String[] args) {
        leetcode_188_买卖股票的最佳时机IV v = new leetcode_188_买卖股票的最佳时机IV();

        int k = 2;
        int[] prices = new int[]{2,4,1};


        int i = v.maxProfit(k, prices);

        System.out.println(i);

    }
}
