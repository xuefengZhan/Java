package dp.线性DP.最长公共子序列LCS问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_1143_最长公共子序列
 * @Author zxf
 * @Date 2023/11/10 11:31
 * @Questinon Describrition
 **/
public class leetcode_1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i < m + 1; i++) {

            for (int j = 1; j < n + 1; j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m][n];

    }


    public static void main(String[] args) {
        leetcode_1143_最长公共子序列 v = new leetcode_1143_最长公共子序列();

        String s1 = "abcde";
        String s2 = "ace";


        int res = v.longestCommonSubsequence(s1, s2);

        System.out.println(res);
    }
}
