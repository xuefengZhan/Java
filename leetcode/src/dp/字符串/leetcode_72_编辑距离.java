package dp.字符串.leetcode_72;

import java.util.Arrays;

/**
 * @ClassName _编辑距离
 * @Author zxf
 * @Date 2023/10/27 17:37
 * @Questinon Describrition
 *
 * 动态转移方程
 *
 *
 **/
public class leetcode_72_编辑距离 {
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();


        int[][] dp = new int[m+1][n+1];

        //初始化


        for (int i = 0; i <= m ; i++) {
            for(int j = 0; j <= n;j++){
                if(i == 0){
                    dp[i][j] = j;
                    continue;
                }
                if(j == 0){
                    dp[i][j] = i;
                    continue;
                }
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    //word1[i-1] 到 word2[j - 1]  =>  word1[i] 到word2[j]
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(
                            Math.min(
                                    dp[i-1][j] ,// 删除字母 word1[i]
                                    dp[i][j-1] // 从word2[j-1] 增加字母word2[j]
                            ),
                            dp[i-1][j-1]//替换word1[i] 为 Word2[j] 相当于从word1[i-1] 和  word2[j-1] 同时增加字母word2[j]
                    ) + 1;
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        return dp[m][n];
    }


    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        leetcode_72_编辑距离 v = new leetcode_72_编辑距离();

        int res = v.minDistance(word1, word2);

        System.out.println(res);
    }
}
