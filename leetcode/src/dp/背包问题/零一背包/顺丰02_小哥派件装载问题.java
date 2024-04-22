package dp.背包问题.零一背包;

/**
 * @ClassName 顺丰02_小哥派件装载问题
 * @Author zxf
 * @Date 2024/3/29 15:38
 * @Questinon Describrition
 *
 * https://leetcode.cn/contest/sf-tech/problems/cINqyA/
 **/
public class 顺丰02_小哥派件装载问题 {

    //N是快递数组
    //V是电瓶车容量

    //让V剩余最小，返回剩余最小容积
    public int minRemainingSpace(int[] N, int V) {
        int[] dp = new int[V+1];  //dp[i]是最大可装容量 i是容量

        for (int n : N) {
            for (int i = V; i >= 0; i--) {
                if(i >= n) dp[i] = Math.max(dp[i],dp[i-n]+n);
            }
        }

        return V - dp[V];

    }
}
