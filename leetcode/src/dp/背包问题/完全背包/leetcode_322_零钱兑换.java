package dp.背包问题.完全背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_322_零钱兑换
 * @Author zxf
 * @Date 2024/4/9 18:11
 * @Questinon Describrition
 **/
public class leetcode_322_零钱兑换 {

    //dp
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;


        //i是金额
        for (int i = 1; i <= amount; i++) {

            // 当前硬币
            for (int cur : coins) {

                if (i >= cur) {
                    dp[i] = Math.min(dp[i], dp[i - cur] + 1);
                }
            }

            System.out.println(Arrays.toString(dp));
        }

        return dp[amount] == Integer.MAX_VALUE? -1 : dp[amount];
    }


    //记忆化搜索
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];


        dfs(coins,amount,dp);

        return dp[amount];

    }


    private int dfs(int[] coins,int amount,int[] dp){
        if(dp[amount] != 0) return dp[amount];
        if(amount == 0) return 0;

        int min = amount+1;
        for (int coin : coins) {
            if(amount >= coin){
                int cur = dfs(coins,amount-coin,dp);

                if(cur < min){
                    min = cur;
                }
            }
        }
        dp[amount] =  min == amount+1 ? -1 : min + 1;
        return dp[amount];
    }


    public static void main(String[] args) {
        leetcode_322_零钱兑换 v = new leetcode_322_零钱兑换();

        int[] coins = {1,2,5};
        int amount = 11;

        int res = v.coinChange(coins, amount);

        System.out.println(res);
    }
}
