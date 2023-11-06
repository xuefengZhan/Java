package dp.打家劫舍;

import java.util.Arrays;

/**
 * @ClassName leetcode_198_打家劫舍
 * @Author zxf
 * @Date 2023/8/29 18:29
 * @Questinon Describrition
 *
 * 100% 自己想的
 *
 * 本题特点：当前的选择对后续是有影响的。
 * [1,2,3] 选择 1 3
 * [1,2,3,4] 选择 2 4
 * 也就是说如果有增加的元素，也需要更改先前的选择
 * 所以本质是遍历所有情况。
 * 当前的状态是受后续的变化而变化的，因此需要增加一个变量，dp[i][0] 表示index = i的元素不选  1为选
 *
 *
 * 如果用一维数组
 * dp[i]   dp[i] = Math.max(dp[i-2] + nums[i],dp[i])
 **/
public class leetcode_198_打家劫舍 {
    public int rob(int[] nums) {
       int[][] dp = new int[nums.length][2];

       dp[0][0] = 0;
       dp[0][1] = nums[0];


        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][0] + nums[i],dp[i-1][1] - nums[i-1] + nums[i]);
        }

        System.out.println(Arrays.deepToString(dp));

        return Math.max(dp[nums.length - 1][0],dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        leetcode_198_打家劫舍 v = new leetcode_198_打家劫舍();
        int[] nums = {1,2,3,4};

        int rob = v.rob(nums);

        System.out.println(rob);
    }
}


