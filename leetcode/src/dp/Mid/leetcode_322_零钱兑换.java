package dp.Mid;

import java.util.Arrays;

/**
 * @ClassName leetcode_322_零钱兑换
 * @Author zxf
 * @Date 2023/9/8 9:53
 * @Questinon Describrition
 *
 *
 * 记忆化搜索
 **/
public class leetcode_322_零钱兑换 {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];

        //初始化
        for (int coin : coins) {
            if(coin < amount) dp[coin] = 1;
        }
        dfs(amount,coins);

        return dp[amount];
    }



    private int dfs(int amount,int[] coins){
        if(amount == 0) return 0;
        if(amount < 0) return -1;

        //todo 记忆化搜索 的核心
        if(dp[amount] != 0)  return dp[amount];


        int res = -1 ;
        for (int coin : coins) {
            int prev = amount - coin;
            int num = dfs(prev,coins);

            if(num == -1) continue;

            if(res == -1){
                res = num + 1;
            }else{
                res = Math.min(res,num + 1);
            }
        }

        dp[amount] = res;
        return dp[amount];
    }


    public static void main(String[] args) {
        leetcode_322_零钱兑换 v = new leetcode_322_零钱兑换();
        int[] coins =  {1, 2, 5};

        int i = v.coinChange(coins, 11);

        System.out.println(i);
    }
}
