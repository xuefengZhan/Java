package dp.Easy;

/**
 * @ClassName leetcode_338_比特位计数
 * @Author zxf
 * @Date 2023/8/14 16:01
 * @Questinon Describrition
 **/
public class leetcode_338_比特位计数 {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;

        for(int i = 0;i<=n;i++){
            if((i & 1) == 1){
                //奇数
                dp[i] = dp[i/2] + 1;
            }else{
                dp[i] = dp[i/2];
            }
        }

        return dp;
    }
}
