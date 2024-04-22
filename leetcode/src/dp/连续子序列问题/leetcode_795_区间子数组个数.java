package dp.连续子序列问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_795_区间子数组个数
 * @Author zxf
 * @Date 2024/3/19 13:42
 * @Questinon Describrition
 **/
public class leetcode_795_区间子数组个数 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return MostK(nums,right) - MostK(nums,left-1);
    }

    private int MostK(int[] nums,int k){
        int res = 0;
        int prev = 0; //dp[i] 简化为单个变量  含义：当前元素作为结尾的 <= k 的连续子序列个数


        for (int i = 0; i < nums.length; i++) {
            if(nums[i] <= k){
                prev += 1;
                res += prev;
            }else{
                prev = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        leetcode_795_区间子数组个数 v = new leetcode_795_区间子数组个数();
        int[] nums = {876,880,482,260,132,421,732,703,795,420,871,445,400,291,358,589,617,202,755,810,227,813,549,791,418,528,835,401,526,584,873,662,13,314,988,101,299,816,833,224,160,852,179,769,646,558,661,808,651,982,878,918,406,551,467,87,139,387,16,531,307,389,939,551,613,36,528,460,404,314,66,111,458,531,944,461,951,419,82,896,467,353,704,905,705,760,61,422,395,298,127,516,153,299,801,341,668,598,98,241};

        int i = v.numSubarrayBoundedMax(nums,658,719);
        System.out.println(i);
    }
}
