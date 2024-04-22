package dp.连续子序列问题;

import java.util.Arrays;

/**
 * @ClassName leetcode_467_环绕字符串中唯一的子字符串
 * @Author zxf
 * @Date 2024/3/19 11:27
 * @Questinon Describrition
 **/
public class leetcode_467_环绕字符串中唯一的子字符串 {
    int[] maxLen = new int[26]; //存储每个字符作为子串结尾的最大长度
    int res ;

    public int findSubstringInWraproundString(String s) {
        int[] dp = new int[s.length()];
        dp[0] = 1;
        maxLen[s.charAt(0) - 'a'] = 1;
        res = 1;

        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i-1);

            int curInedx = cur - 'a';

            //如果连续
            if((cur == prev + 1 || cur == prev - 25) ){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 1;
            }

            if(maxLen[curInedx] < dp[i]){
                res+= dp[i] - maxLen[curInedx];
                maxLen[curInedx] = dp[i];
            }

        }

        System.out.println(Arrays.toString(maxLen));
        return res;
    }

    public static void main(String[] args) {
        leetcode_467_环绕字符串中唯一的子字符串 v = new leetcode_467_环绕字符串中唯一的子字符串();
        String s = "zaba";
        int res = v.findSubstringInWraproundString(s);

        System.out.println(res);
    }
}
