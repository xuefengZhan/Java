package dp.求子序列;

import java.util.Arrays;

/**
 * @ClassName leetcode_413_等差数列划分
 * @Author zxf
 * @Date 2024/3/14 10:24
 * @Questinon Describrition
 **/
public class leetcode_413_等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<=2) return 0;

        int n = nums.length;

        int res = 0;
        int[] dp = new int[n];

        for (int i = 2; i < n; i++) {
            int a = nums[i-1];
            int b = nums[i-2];

            if(nums[i] - a == a - b){
                dp[i] = dp[i-1] + 1;
            }

            res += dp[i];
        }

        System.out.println(Arrays.toString(dp));
        return res;
    }
}
