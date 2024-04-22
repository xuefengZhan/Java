package dp.背包问题.完全背包;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName leetcode_518_零钱兑换II
 * @Author zxf
 * @Date 2024/3/28 18:25
 * @Questinon Describrition
 **/
public class leetcode_518_零钱兑换II {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        dp[0] = 1; //金额为0的时候 能凑出1种组合 就是不选


        //
        for (int coin : coins)  {
            //
            for (int i = coin; i <= amount; i++){
                    dp[i] += dp[i -coin];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }


    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};

        leetcode_518_零钱兑换II v = new leetcode_518_零钱兑换II();

        int res = v.change(amount, coins);

        System.out.println(res);

    }


}
