package dp.字符串;

import java.util.Arrays;

/**
 * @ClassName leetcode_712_两个字符串的最小ASCII删除和
 * @Author zxf
 * @Date 2023/10/30 9:34
 * @Questinon Describrition
 *
 * 11ms
 *      | ''   | s | e | a
 *      ————————————————
 *    ''| 0   | s  |s+e|s+e+a
 *    e | e   |s+e | s |e+a   (dp[i][j-1] + a  而不是 dp[i-1][j] + e)
 *    a |e+a  |
 *    t |e+a+t|
 **/
public class leetcode_712_两个字符串的最小ASCII删除和 {
    public int minimumDeleteSum(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m+1][n+1];

        //初始化
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i-1][0] + c1[i-1];
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i-1] + c2[i-1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j] + c1[i-1] , dp[i][j-1] + c2[j-1]);
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m][n];
    }
}
