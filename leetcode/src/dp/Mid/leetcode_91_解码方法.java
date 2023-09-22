package dp.Mid;

/**
 * @ClassName leetcode_91_解码方法
 * @Author zxf
 * @Date 2023/8/24 14:19
 * @Questinon Describrition
 **/


import java.util.Arrays;

/**
 * 回溯解法 超时了
 */
//public class leetcode_91_解码方法 {
//    int res = 0;
//    public int numDecodings(String s) {
//        dfs(s,0);
//        return res;
//    }
//
//
//    private void dfs(String s,int start){
//        if(start == s.length()){
//            res++;
//            return;
//        }
//        //要么选1个字母来解码 要么选两个字母来解码
//        for (int num = 1; num <= 2; num++) {
//            if(start + num > s.length()) continue;
//            String sub = s.substring(start, start + num);
//            if( ! is_ok(sub)) continue;
//            dfs(s,start+num);
//        }
//    }
//
//
//    private boolean is_ok(String s){
//        int  i = Integer.parseInt(s);
//        if(s.length() == 1 && (i > 0 && i < 10)) return true;
//        return s.length() == 2 && (i > 9 && i < 27);
//    }
//
//    public static void main(String[] args) {
//        leetcode_91_解码方法 v = new leetcode_91_解码方法();
//
//        String s = "12";
//
//        int res = v.numDecodings(s);
//
//        System.out.println(res);
//
//    }
//}

/**
 * dp解法： 1ms 38.55%
 */
public class leetcode_91_解码方法{
    private boolean is_ok(String s){
        int  i = Integer.parseInt(s);
        if(s.length() == 1 && (i > 0 && i < 10)) return true;
        return s.length() == 2 && (i > 9 && i < 27);
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        //dp[0]表示没有字符的时候的结果
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            String s1 = s.substring(i - 1, i);
            if(is_ok(s1)){
                dp[i] += dp[i-1];
            }

            if(i > 1){
                String s2 = s.substring(i - 2, i);
                if(is_ok(s2)){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        leetcode_91_解码方法 v = new leetcode_91_解码方法();

        String s = "06";

        int res = v.numDecodings(s);

        System.out.println(res);

    }
}