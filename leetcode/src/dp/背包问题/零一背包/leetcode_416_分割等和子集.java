package dp.背包问题.零一背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_416_分割等和子集
 * @Author zxf
 * @Date 2024/3/14 15:34
 * @Questinon Describrition
 **/
public class leetcode_416_分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if((sum & 1) == 1) return false; // 奇数不可分

        sum = sum / 2;



        int m = sum;
        int n = nums.length;

        boolean[][] dp = new boolean[m+1][n+1];

        Arrays.fill(dp[0],true); //和为0都能拼凑成


        for (int j = 1; j <= n; j++) {

            int last = nums[j - 1];

            for (int i = 1; i <= m; i++) {
                dp[i][j] = dp[i][j-1];
                if(i >= last) dp[i][j] = dp[i][j] || dp[i - last][j-1];
            }
        }


        System.out.println(Arrays.deepToString(dp));
        return dp[m][n];
    }

    public static void main(String[] args) {
        leetcode_416_分割等和子集 v = new leetcode_416_分割等和子集();
        int[] nums = {1,5,10,6};

        boolean res = v.canPartition(nums);

        System.out.println(res);
    }
}
