package dp.字符串;

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

        for (int i = len-1; i >=0; i--) {
            for (int j = i; j < len; j++) {
                if(j == i){
                    dp[i][j] = true;
                }else if(j == i + 1 && charArray[i] == charArray[j]){
                    dp[i][j] = true;
                }else if(dp[i+1][j-1] && charArray[i] == charArray[j]){
                    dp[i][j] = true;
                }

                if(dp[i][j]){
                    if(j - i + 1 > maxLen){
                        res = s.substring(i,j+1);
                    }
                    maxLen = Math.max(maxLen,j - i + 1);
                }
            }
        }

        return res;
    }


    public static void main(String[] args) {
        leetcode_5_最长回文子串 v = new leetcode_5_最长回文子串();

        String s = "aacabdkacaa";
        String res = v.longestPalindrome(s);

        System.out.println(res);

    }
}
