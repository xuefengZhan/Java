package 哈希表;

import java.util.HashSet;

/**
 * @ClassName leetcode_2670_找出不同元素数目差数组
 * @Author zxf
 * @Date 2024/1/31 15:14
 * @Questinon Describrition
 **/
public class leetcode_2670_找出不同元素数目差数组 {
    public int[] distinctDifferenceArray(int[] nums) {
        int total = 0;

        //map存储 0到i中不同的元素个数
        int[] map = new int[nums.length];
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            map[i] = set.size();
        }

        set.clear();

        for (int i = nums.length - 2; i >= 0; i--) {
            set.add(nums[i+1]);
            map[i] = map[i] - set.size();
        }

        return map;
    }
}
