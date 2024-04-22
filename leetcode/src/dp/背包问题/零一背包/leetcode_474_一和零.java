package dp.背包问题.零一背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_474_一和零
 * @Author zxf
 * @Date 2024/3/25 13:53
 * @Questinon Describrition
 *
 *  1. dp[i] 表示[0,i]的最大子集  不行 没法递推
 *           表示包含i的最大子集   不行
 **/
public class leetcode_474_一和零 {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i < strs.length; i++) {

            String str = strs[i];
            int a = 0;
            int b = 0;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '0') a++;
                else b++;
            }

            for (int x = m; x >= a; x--) {
                for (int y = n; y >= b ; y--) {
                   dp[x][y] = Math.max(dp[x][y],dp[x-a][y-b] + 1);

                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        leetcode_474_一和零 v = new leetcode_474_一和零();

        String[] strs = {"10", "0001", "111001", "1", "0"};

        int m = 5;
        int n = 3;

        int res = v.findMaxForm(strs, m, n);
        System.out.println(res);
    }
}
