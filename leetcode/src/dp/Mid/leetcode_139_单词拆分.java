package dp.Mid;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName leetcode_139_单词拆分
 * @Author zxf
 * @Date 2023/8/29 11:05
 * @Questinon Describrition
 *
 * 官方题解
 **/

public class leetcode_139_单词拆分 {
    int n ;
    HashSet<String> set;
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dp = new  boolean[n + 1];
        set = new HashSet(wordDict);


        //dp[i]
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }







    public static void main(String[] args) {
        leetcode_139_单词拆分 v = new leetcode_139_单词拆分();
        String s = "cars";
        List<String>  worDict = new ArrayList<>();

        worDict.add("car");
        worDict.add("ca");

        worDict.add("rs");



        boolean b = v.wordBreak(s, worDict);

        System.out.println(b);
    }

}