package dp.No01_入门.爬楼梯;

/**
 * @ClassName leetcode_2266_统计打字方案数
 * @Author zxf
 * @Date 2024/4/19 11:55
 * @Questinon Describrition
 *
 * 难度：1857
 **/
public class leetcode_2266_统计打字方案数 {

    long res = 1;

    long[] dp3 ;
    long[] dp4 ;
    int mod = 1000000007;

    public int countTexts(String pressedKeys) {
        int l = pressedKeys.length();

        int n = Math.max(l,4);

        dp3 = new long[n+1];
        dp4 = new long[n+1];

        dp3[0] = 1;
        dp3[1] = 1;
        dp3[2] = 2;
        dp3[3] = 4;

        dp4[0] = 1;
        dp4[1] = 1;
        dp4[2] = 2;
        dp4[3] = 4;




        //选项
        for (int i = 4; i <= n; i++) {
            //不重复 忽略再拆分 比如dp[4] = dp[2] + 2个元素 这两个元素就不要考虑再拆分了，因为在dp[3] + 1中已经考虑了被拆分的情况了
            dp3[i] = (dp3[i-1] + dp3[i-2] + dp3[i-3] ) % mod;
            dp4[i] = (dp4[i-1] + dp4[i-2] + dp4[i-3] + dp4[i-4] ) % mod;

        }

        //System.out.println(Arrays.toString(dp));

        int prev = 0;
        char a = pressedKeys.charAt(0);

        for (int i = 0; i <= l; i++) {

            if (i == l || pressedKeys.charAt(i)!= a ){

                char last = pressedKeys.charAt(i-1);

                if(last == '7' || last == '9'){
                    res = (res * dp4[i-prev]) % mod;
                }else{
                    res = (res * dp3[i-prev]) % mod;
                }

                prev = i;
                if(i < l) a = pressedKeys.charAt(i);
            }
        }

        return (int) res;
    }




    public static void main(String[] args) {
        leetcode_2266_统计打字方案数 v = new leetcode_2266_统计打字方案数();

    }
}
