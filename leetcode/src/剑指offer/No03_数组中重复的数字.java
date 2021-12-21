package 剑指offer;

import java.util.HashSet;
import java.util.stream.Stream;

public class No03_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        int[] ints = new int[nums.length];
        for (int num : nums) {
            ints[num] ++;
            if(ints[num] > 1) return num;
        }
        return -1;
    }
}
