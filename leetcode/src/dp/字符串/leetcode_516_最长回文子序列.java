package dp.字符串;

import java.util.Arrays;

/**
 * @ClassName leetcode_516_最长回文子序列
 * @Author zxf
 * @Date 2023/10/26 17:37
 * @Questinon Describrition
 **/
public class leetcode_516_最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();

        int[][] dp = new int[n][n];


        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if(i == j){
                    dp[i][j] = 1;
                }else if(chars[j] == chars[i]){
                     dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[0][n-1];
    }
}
