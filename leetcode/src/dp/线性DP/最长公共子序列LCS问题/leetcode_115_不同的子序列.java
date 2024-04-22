package dp.线性DP.最长公共子序列LCS问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_115_不同的子序列
 * @Author zxf
 * @Date 2023/10/30 14:05
 * @Questinon Describrition
 *
 * 6ms 自己想的

 **/
public class leetcode_115_不同的子序列 {
    public int numDistinct(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();


        int m = t.length();
        int n = s.length();


        int[][] dp = new int[m+1][n+1];


        //初始化第一行
        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //第一列必然全是0 所以j从1开始
                if(c2[i-1] == c1[j-1]){
                    //dp[i][j-1]    截至s[j-1] 已有的t[i]子串数   (前面累计)
                    //dp[i-1][j-1]  截至s[j-1] 已有的t[i-1]子串数 (当前新增)
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }

            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        leetcode_115_不同的子序列 v = new leetcode_115_不同的子序列();

        String s = "rabbbit";
        String t = "rabbit";

        int i = v.numDistinct(s, t);
        System.out.println(i);

        String s1 = "babgbag";
        String t1 = "bag";

        int i1 = v.numDistinct(s1, t1);
        System.out.println(i1);
    }
}
