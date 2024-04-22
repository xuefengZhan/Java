package dp.求子序列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode_368_最大整除子集
 * @Author zxf
 * @Date 2024/3/12 14:52
 * @Questinon Describrition
 **/
public class leetcode_368_最大整除子集 {
    int[] dp ;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,1);

        int maxDp = 0;//存储最长列表的长度
        int maxVal = 0; // 存储最长列表的最大值
        for (int i = 1; i < nums.length; i++) {
            //遍历之前最大的可整除的位置
            for (int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }

            if(dp[i] > maxDp){
                maxDp = dp[i];
                maxVal = nums[i];
            }

        }


        List<Integer> res = new ArrayList<>();


        for (int i = dp.length - 1; maxDp >= 1 && i >= 0; i--) {
            if(maxVal  % nums[i] == 0 && dp[i] == maxDp ){
                res.add(nums[i]);
                maxDp--;
                maxVal = nums[i];
            }
        }

        System.out.println(res);
        return res;

    }


    public static void main(String[] args) {
        leetcode_368_最大整除子集 v = new leetcode_368_最大整除子集();
        int[] nums = {2,3,4,8};

        List<Integer> integers = v.largestDivisibleSubset(nums);

        System.out.println(integers);
    }

}
