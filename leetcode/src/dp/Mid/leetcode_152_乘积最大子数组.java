package dp.Mid;

/**
 * @ClassName leetcode_152_乘积最大子数组
 * @Author zxf
 * @Date 2023/8/29 15:40
 * @Questinon Describrition
 **/
public class leetcode_152_乘积最大子数组 {
    int[][] dp;
    public int maxProduct(int[] nums) {
        dp = new int[nums.length][2];

        dp[0][0] = nums[0];
        dp[0][1] = dp[0][0];

        int res = dp[0][1];
        int a = 0;
        int b = 0;
        int c = 0;

        for (int i = 1; i < nums.length; i++) {
            a = nums[i];
            b = nums[i] * dp[i-1][0];
            c = nums[i] * dp[i-1][1];
            dp[i][0] = Math.min(Math.min(a ,b),c);
            dp[i][1] = Math.max(Math.max(a ,b),c);

            res = Math.max(res,dp[i][1]);
        }


        return res;
    }


    public static void main(String[] args) {
        leetcode_152_乘积最大子数组 v = new leetcode_152_乘积最大子数组();
        int[] nums = {2,3,-2,4};

        int i = v.maxProduct(nums);
        System.out.println(i);


    }
}
