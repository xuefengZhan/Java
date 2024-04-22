package dp.背包问题.零一背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_3082_求出所有子序列的能量和
 * @Author zxf
 * @Date 2024/4/2 14:35
 * @Questinon Describrition
 **/
public class leetcode_3082_求出所有子序列的能量和 {
    // 和 等于 k 的子序列的数目
    public int sumOfPower(int[] nums, int k) {
        int n = nums.length;

        long[][] dp = new long[k+1][n+1];  //i是和 k是元素个数  值是个数

        int mod = 1000000007;

        dp[0][0] = 1;

        //i 当前元素
        for (int i = 0; i < n; i++) {

            int  cur = nums[i];
            //j是和
            for (int j = k; j >= cur; j--) {
                //l是 和为j的子序列元素个数
                for (int l = n; l >= 1; l--) {
                    //当前元素不选
                    dp[j][l] = (dp[j][l] +  dp[j-cur][l-1]) % mod;
                }
            }
        }

        long[] ints = dp[k]; //取出和为k的数组

        System.out.println(Arrays.toString(ints));

        long res = 0;

        //i是元素个数
        for (int i = 0; i < ints.length; i++) {

            //i是和为k的子序列的长度
            int num = power(n - i);

            long anInt = ints[i]; //方案数


            res = (res + anInt * num) % mod;
        }

        return (int) res;
    }


    private int power(int x){
        int res = 1;

        for (int i = 0; i < x; i++) {
            res *= 2;
        }
        return res;
    }


    public static void main(String[] args) {
        leetcode_3082_求出所有子序列的能量和 v = new leetcode_3082_求出所有子序列的能量和();

        int[] nums = {1,2,3};
        int k = 3;

        int res = v.sumOfPower(nums, k);

        System.out.println(res);
    }
}
