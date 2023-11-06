package dp.字符串;

import java.util.ArrayList;
import java.util.Arrays;
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
    boolean[] dp;

    public boolean wordBreak(String s, List<String> wordDict) {

        int len = s.length();
        dp = new boolean[len + 1];
        dp[0] = true;

        //i是 结尾索引 + 1
        for (int i = 1; i <= len; i++) {
            for (String word : wordDict) {
                int n = word.length();
                if(n > i) continue;  //如果单词长度超过当前 长度

                String substring = s.substring(i - n, i); //i - n 是索引
                if(substring.equals(word)){
                    dp[i] = dp[i - n];
                    if(dp[i]) break;
                }
            }
        }
        return dp[len];
    }






    public static void main(String[] args) {
        leetcode_139_单词拆分 v = new leetcode_139_单词拆分();
        String s = "leetcode";
        List<String>  worDict = new ArrayList<>();

        worDict.add("leet");
        worDict.add("code");


        boolean b = v.wordBreak(s, worDict);

        System.out.println(b);
    }

}