package dp.Easy;

/**
 * @ClassName leetcode_1646_获取生成数组中的最大值
 * @Author zxf
 * @Date 2023/8/18 11:23
 * @Questinon Describrition
 **/
public class leetcode_1646_获取生成数组中的最大值 {
    public int getMaximumGenerated(int n) {
        if(n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        int res = 1;

        for(int i = 2;i <= n ; i++){
            if((i & 1) == 1){
                //奇数
                int x = (i - 1) >> 1;
                dp[i] = dp[x] + dp [x + 1];
            }else{
                dp[i] = dp[i>>1];
            }

            res = Math.max(res,dp[i]);
        }

        return res;
    }
}
