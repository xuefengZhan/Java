package dp.线性DP.最长递增子序列LIS问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_673_最长递增子序列的个数
 * @Author zxf
 * @Date 2023/10/31 15:20
 * @Questinon Describrition
 **/
public class leetcode_673_最长递增子序列的个数 {
    public int findNumberOfLIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];

        int[] cnts = new int[n];

        dp[0] = 1;
        cnts[0] = 1;

        //int res = 0;
        int dpMax = 1;
        int maxNum = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; //给默认值

            int prevSmallerMax = 0;
            int num = 1; //初始化给1 如果i-1子序列中没有比nums[i]小的，默认给1

            for(int j = 0;j<i;j++){
                if(nums[j] < nums[i]){
                    if(dp[j] > prevSmallerMax){
                        prevSmallerMax = dp[j];
                        num = cnts[j];
                    }else if(dp[j] == prevSmallerMax){
                        num += cnts[j];
                    }

                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }


            //dp[i] 确定
            if(dp[i] > dpMax){
                dpMax = dp[i];
                maxNum = num;
            }else if(dp[i] == dpMax){
                maxNum += num;
            }

            cnts[i] = num;
        }


        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(cnts));

        return maxNum;
    }


    public static void main(String[] args) {
        leetcode_673_最长递增子序列的个数 v = new leetcode_673_最长递增子序列的个数();

        //int[] nums = {1,2,4,3,3,5,4,7,2};
        //int[] nums = {1};
        //int[] nums = {3,1,2};
        //int[] nums = {2,2,2,2,2};
        int[] nums = {1,3,2};
        int res = v.findNumberOfLIS(nums);

        System.out.println(res);

    }
}
