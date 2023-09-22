package dp.Mid;

import java.util.Arrays;

/**
 * @ClassName leetcode_97_交错字符串
 * @Author zxf
 * @Date 2023/8/25 11:16
 * @Questinon Describrition
 *
 * s3要么从s1取要么从s2取 按顺序
 *
 * 两边都可以选 选了后要保证下一次需要的能被选到
 *
 * 88.7%
 **/
public class leetcode_97_交错字符串 {


    public boolean isInterleave(String s1, String s2, String s3) {

        int l1 = s1.length();
        int l2 = s2.length();
        int l3 = s3.length();

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();


        if(l3 != l1 + l2) return false;


        boolean[][] dp = new boolean[l1 + 1][l2 + 1];

        //初始化dp
        dp[0][0] = true;

        //初始化第一列
        int k = 0;
        for (int i = 1; i < l1 + 1; i++) {
            if(! dp[i-1][0] ) break;
            dp[i][0] = dp[i-1][0] && c3[k++] == c1[i-1];
        }
        //初始化第一行
        k = 0;
        for (int i = 1; i < l2 + 1; i++) {
            if(! dp[0][i-1] ) break;
            dp[0][i] = dp[0][i-1] && c3[k++] == c2[i-1];
        }


//        for (boolean[] booleans : dp) {
//            System.out.println(Arrays.toString(booleans));
//        }


        boolean b1 = false;
        boolean b2 = false;


        k = 0;
        //dp数组的i行 j列 对应c1[i-1] 和 c2[j-1]
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                k = i + j - 1;
                b1 = dp[i - 1][j] && c1[i - 1] == c3[k];
                b2 = dp[i][j - 1] && c2[j - 1] == c3[k];

                dp[i][j] = b1 || b2;
            }
        }


        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }

        return dp[l1][l2];

    }







    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";

        leetcode_97_交错字符串 v = new leetcode_97_交错字符串();
        boolean res = v.isInterleave(s1, s2, s3);

        System.out.println(res);

    }
}
