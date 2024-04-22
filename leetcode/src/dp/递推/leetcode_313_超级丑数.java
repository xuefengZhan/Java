package dp.递推;

import java.util.Arrays;

/**
 * @ClassName leetcode_313_超级丑数
 * @Author zxf
 * @Date 2024/3/12 10:28
 * @Questinon Describrition
 *
 * 这题和264的思路是一样的，不同点在于这里的质数集是随机的
 **/
public class leetcode_313_超级丑数 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;

        //ps[i] 指 丑数primes[i] 下一次该乘以dp数组中第几个丑数
        int[] pointers = new int[m];
        Arrays.fill(pointers,1);//初始都指向第一个丑数 也就是1

        //dp[i] 表示第i个丑数是dp[i]
        int[] dp = new int[n+1];
        dp[1] = 1;

        //求第i位丑数
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            //获取新的最小丑数  注意  这里 是获取最小的，题目保证了最小的是在int范围内的，但是
            //可能会存在primes[j] * dp[ps[j]] 越界了，因此这里用long类型比较好
            for (int j = 0; j < m; j++) {
                int cur = primes[j] * dp[pointers[j]];
                if(cur < 0) continue;
                min = Math.min(min,cur);
            }

            dp[i] = min;

            //计算该最小丑数是从哪个丑数乘上来的
            for (int j = 0; j < m; j++) {
                if(primes[j] * dp[pointers[j]] == min){
                    pointers[j] ++;
                }
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
