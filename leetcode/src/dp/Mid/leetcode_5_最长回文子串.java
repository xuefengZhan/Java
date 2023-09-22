package dp.Mid;

import java.util.Arrays;

/**
 * @ClassName leetcode_5_最长回文子串
 * @Author zxf
 * @Date 2023/8/23 13:44
 * @Questinon Describrition
 **/
public class leetcode_5_最长回文子串 {
    public String longestPalindrome(String s) {
        int len = s.length();

        boolean[][] dp = new boolean[len][len];

        //dp[i][j] 表示s[i,j]是否是回文串
        char[] charArray = s.toCharArray();
        int maxLen = 0;

        String res = null;


        //遍历顺序：dp[i][j] 由dp[i+1][j-1]确定，所以必须得先确定dp[i+1][j-1]
        //所以得从下往上 从左往右
        for (int i = len-1; i >=0; i--) {
            for (int j = i; j < len; j++) {
                if(j == i){
                    dp[i][j] = true;
                }else if(charArray[i] == charArray[j]){
                    if(j == i + 1 || dp[i+1][j-1]){
                        dp[i][j] = true;
                    }
                }

                if(dp[i][j] && j - i + 1 > maxLen){
                    res = s.substring(i,j+1);
                    maxLen = Math.max(maxLen,j - i + 1);
                }

            }
        }

        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }

        return res;
    }


    public static void main(String[] args) {
        leetcode_5_最长回文子串 v = new leetcode_5_最长回文子串();

        String s = "cbad";
        String res = v.longestPalindrome(s);

        System.out.println(res);

    }
}
