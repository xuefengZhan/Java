package dp.背包问题.分组背包;

import java.util.Arrays;

/**
 * @ClassName leetcode_1981_最小化目标值与所选元素的差
 * @Author zxf
 * @Date 2024/4/18 16:46
 * @Questinon Describrition
 **/
public class leetcode_1981_最小化目标值与所选元素的差 {

    // v1. 二阶数组
//    public int minimizeTheDifference(int[][] mat, int target) {
//
//        int m = mat.length;
//        int n = mat[0].length;
//
//        //i 是层级
//        //j 是目标和
//        int[][] dp = new int[m+1][4900+1];
//
//        //为1 表示有这个值  0则没有
//        dp[0][0] = 1;
//
//        //i是dp数组的层级
//        for (int i = 1; i <= m; i++) {
//            //x是列
//            for (int x = 0; x < n; x++) {
//
//                int y = mat[i-1][x];
//
//                for (int j = y; j <= 4900; j++) {
//                    //
//                    if(dp[i-1][j-y] != 0){
//                        dp[i][j] = dp[i-1][j-y];
//                    }
//                }
//            }
//        }
//
//
//        int[] res = dp[m];
//
//        System.out.println(res[target]);
//        System.out.println(Arrays.toString(res));
//
//        if(res[target] == 1) return 0;
//
//        int distance = Math.max(target,4900-target);
//
//        for (int i = 1; i < distance; i++) {
//            if(target >= i && res[target - i] == 1) return i;
//            if(target + i <= 4900 && res[target + i] == 1) return i;
//        }
//
//        return -1;
//    }

    public int minimizeTheDifference(int[][] mat, int target) {

        int m = mat.length;
        int n = mat[0].length;
        int maxLen = Math.max(m * 70,target);
        //i 是层级
        //j 是目标和
        boolean[] dp = new boolean[maxLen+1];

        //为1 表示有这个值  0则没有
        dp[0] = true;

        //i是dp数组的层级
        for (int i = 1; i <= m; i++) {
            for (int j = maxLen; j >= 0; j--) {
                dp[j] = false; //因为是新一行的j 初始默认为0 表示第i行达不到目标和为j
                //x是列
                for (int x = 0; x < n; x++) {
                    int y = mat[i-1][x];
                    //
                    if(j >= y && dp[j-y]){
                        dp[j] = true;
                        break;
                    }
                }
            }
        }

        if(dp[target]) return 0;

        int distance = Math.max(target,maxLen -target);

        for (int i = 1; i < distance; i++) {
            if(target >= i && dp[target - i]) return i;
            if(target + i <= maxLen && dp[target + i]) return i;
        }

        return -1;
    }
}
