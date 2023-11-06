package dp.子序列问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName leetcode_354_俄罗斯套娃信封问题
 * @Author zxf
 * @Date 2023/11/2 15:56
 * @Questinon Describrition
 *
 * 贪心 + dp
 **/
public class leetcode_354_俄罗斯套娃信封问题 {
    /**
     * 自己写的超时
     * @param envelopes
     * @return
     */
//    public int maxEnvelopes(int[][] envelopes) {
//
//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                int res = o1[0] - o2[0];
//
//                return res == 0 ? o1[1] - o2[1] : res;
//            }
//        });
//
//        System.out.println(Arrays.deepToString(envelopes));
//
//        int n = envelopes.length;
//        int[] dp = new int[n];
//        int res = 1;
//
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//            for (int j = i-1; j >= 0; j--) {
//                //往前找 第一个符合要求的dp + 1就是当前的
//                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
//                    dp[i] = Math.max(dp[j] + 1,dp[i]);
//
//                    if(dp[i] == res + 1) break;
//                }
//            }
//            res = Math.max(res,dp[i]);
//        }
//
//        System.out.println(Arrays.toString(dp));
//        return res;
//    }


//    public int maxEnvelopes(int[][] envelopes) {
//        if (envelopes.length == 0) {
//            return 0;
//        }
//
//        int n = envelopes.length;
//        //w升序 h降序
//        Arrays.sort(envelopes, new Comparator<int[]>() {
//            public int compare(int[] e1, int[] e2) {
//                if (e1[0] != e2[0]) {
//                    return e1[0] - e2[0];
//                } else {
//                    return e2[1] - e1[1];
//                }
//            }
//        });
//
//
//
//        int[] f = new int[n];
//        Arrays.fill(f, 1);
//        int ans = 1;
//        for (int i = 1; i < n; ++i) {
//            for (int j = 0; j < i; ++j) {
//                //h是降序的，如果i[1] > j[1] 那说明 i[0] 必然 > j[0]
//                if (envelopes[j][1] < envelopes[i][1]) {
//                    f[i] = Math.max(f[i], f[j] + 1);
//                }
//            }
//            ans = Math.max(ans, f[i]);
//        }
//        return ans;
//    }
//
//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/russian-doll-envelopes/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
