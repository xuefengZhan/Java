package dp.Mid;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode_120_三角形最小路径和
 * @Author zxf
 * @Date 2023/8/28 9:54
 * @Questinon Describrition
 *
 * 这一题和64题区别在于 64题求的是到达某一明确点的最小路径  这题是最底层多个点中的最小值 本质是不变的
 * 直接用一个变量存当前层最小值即可
 **/
public class leetcode_120_三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] dp = new int[n+1];

        //初始化
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j+1],dp[j]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
