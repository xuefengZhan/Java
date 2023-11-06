package dp.子序列问题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leetcode_1218_最长定差子序列
 * @Author zxf
 * @Date 2023/11/1 15:31
 * @Questinon Describrition
 **/
public class leetcode_1218_最长定差子序列 {
//    public int longestSubsequence(int[] arr, int difference) {
//        int n = arr.length;
//        int[] dp = new int[n];
//
//        //map存储某个值的最大序列号
//        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//
//        int res = 0;
//
//        for (int i = 0; i < n; i++) {
//
//            int prev = arr[i] - difference;
//
//            Integer prevValue = map.getOrDefault(prev,0);
//            Integer curValue = map.getOrDefault(arr[i],0);
//
//            dp[i] = Math.max(prevValue+1,curValue) ;
//            map.put(arr[i],dp[i]);
//
//            res = Math.max(res,dp[i]);
//        }
//
//        System.out.println(Arrays.toString(dp));
//        return res;
//    }


//    public int longestSubsequence(int[] arr, int difference) {
//        int n = arr.length;
//        Map<Integer, Integer> map = new HashMap<>();
//        int max = 1;
//        for (int i = 0; i < n; ++i) {
//            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
//            max = Math.max(max, map.get(arr[i]));
//        }
//        return max;
//    }

    //用数组来当hash表
    public int longestSubsequence(int[] arr, int difference) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        int[] dp = new int[max - min + 1];
        max = 1;

        for (int i = 0; i < arr.length; i++) {
            int cur = arr[i] - min, pred = cur - difference;
            if (pred >= 0 && pred < dp.length) {
                dp[cur] = 1 + dp[pred];
                if (dp[cur] > max) max = dp[cur];
            } else {
                dp[cur] = 1;
            }
        }
        return max;
    }
}
