package dp.No01_入门.最大子数组和;

import java.util.Arrays;

/**
 * @ClassName leetcode_2606_找到最大开销的子字符串
 * @Author zxf
 * @Date 2024/4/23 17:24
 * @Questinon Describrition
 *
 * 最大连续子串
 **/
public class leetcode_2606_找到最大开销的子字符串 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] values = new int[26];

        Arrays.fill(values,1001);

        for (int i = 0; i < chars.length(); i++) {
            int index = chars.charAt(i) - 'a';
            values[index] = vals[i];
        }

        for (int i = 0; i < values.length; i++) {
            if(values[i] == 1001){
                values[i] = i + 1;
            }
        }

        //
        int n = s.length();
        int[] dp = new int[n+1];

        //空字符串
        dp[0] = 0;
        int res = 0;




        for (int i = 1; i <= n; i++) {
            int value  = values[s.charAt(i-1) - 'a'];

            if(dp[i-1] < 0){
                dp[i] = value;
            }else{
                dp[i] = value + dp[i-1];
            }

            res = Math.max(dp[i],res);
        }

        return res;
    }
}
