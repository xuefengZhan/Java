package dp.背包问题.零一背包;

/**
 * @ClassName leetcode_1049_最后一块石头的重量II
 * @Author zxf
 * @Date 2024/4/1 13:52
 * @Questinon Describrition
 *
 * - 01背包的最值问题
 **/
public class leetcode_1049_最后一块石头的重量II {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int target = sum >> 1;

        int n = stones.length;
        //找一个最接近sum的值
        int[] dp = new int[target+1];

        for (int j = 1; j <= n; j++) {
            int cur = stones[j-1];
            for (int i = target; i >= 1 ; i--) {
               dp[i] = Math.max(dp[i], dp[i - cur] + cur);
            }
        }

        return sum - 2 * dp[target];
    }
}
