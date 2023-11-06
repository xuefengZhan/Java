package dp.子序列问题;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName leetcode_646_最长数对链
 * @Author zxf
 * @Date 2023/11/1 15:01
 * @Questinon Describrition
 *
 * 300题的改编
 * 贪心解法：想获取最长的，在选取当前节点的时候 选择尽量小的
 **/
public class leetcode_646_最长数对链 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int n = pairs.length;

        int res = 1;
        int prev = pairs[0][1];
        for (int i = 1; i < n; i++) {
            if(pairs[i][0] > prev){
                res++;
                prev = pairs[i][1];
            }
        }

        return res;
    }
}
