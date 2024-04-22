package dp.背包问题.零一背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_1774_最接近目标价格的甜点成本
 * @Author zxf
 * @Date 2024/4/1 15:33
 * @Questinon Describrition
 **/
public class leetcode_1774_最接近目标价格的甜点成本 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int min = Integer.MAX_VALUE;

        for (int baseCost : baseCosts) {
            min = Math.min(min,baseCost);
        }

        //情况1.甜筒的最小价格就已经大于target了
        if(min >= target) return min;

        int n = 2 * target - min; // target + (target - min )  下限确定后 上限也能确定

        boolean[] dp = new boolean[n + 1];

        for (int baseCost : baseCosts) {
            if(baseCost <= n) dp[baseCost] = true;
        }

        for (int toppingCost : toppingCosts) {
            for (int i = n; i > min; i--) {
                if(i >= toppingCost * 2){
                    dp[i] = dp[i] || dp[i - toppingCost * 2] || dp[i - toppingCost];
                }else if(i >= toppingCost){
                    dp[i] = dp[i] || dp[i - toppingCost];
                }else {
                    break;
                }
            }
        }

        int res = 0;

        for (int i = 0; i <= target - min; i++) {
            int left = target - i;
            int right = target + i;

            if(dp[left] && !dp[right]){
                res = left;
                break;
            }

            if(dp[left] && dp[right]){
                res = left;
                break;
            }

            if(!dp[left] && dp[right]){
                res = right;
                break;
            }

        }

        return res;
    }
}
