package dp.No01_入门.最大子数组和;

import java.util.Arrays;

/**
 * @ClassName leetcode_2321_拼接数组的最大分数
 * @Author zxf
 * @Date 2024/4/26 14:16
 * @Questinon Describrition
 *
 * 核心还是求最大连续子数组
 **/
public class leetcode_2321_拼接数组的最大分数 {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = nums2[i] - nums1[i];
        }

        int preva = 0;
        int previ = 0;

        int max = 0;
        int min = 0;

        for (int i : diff) {
            preva = Math.max(i,preva+i);
            max = Math.max(preva,max);

            previ = Math.min(i,previ+i);
            min = Math.min(previ,min);
        }

        int s1 = Arrays.stream(nums1).sum();
        int s2 = Arrays.stream(nums2).sum();

        //System.out.println(max);
        //System.out.println(min);
        int ori2 = Math.max(s1+max,s2-max);
        int ori3 = Math.max(s1+min,s2-min);

        return  Math.max(ori2,ori3);


    }
}
