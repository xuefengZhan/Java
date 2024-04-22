package dp.入门.打家劫舍;

/**
 * @ClassName leetcode_740_删除并获得点数
 * @Author zxf
 * @Date 2023/10/12 18:24
 * @Questinon Describrition
 *
 * 4ms
 * 击败 46.59%使用 Java 的用户
 *
 * 本质和打家劫舍没区别
 **/
public class leetcode_740_删除并获得点数 {

    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max,num);
        }
        int[] dp = new int[max + 1];


        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            dp[num]++;
        }

        return help(dp);

    }


    private int help(int[] nums){

        int first = 0;
        int second = nums[1];

        for (int i = 2; i < nums.length; i++) {
            int tmp = Math.max(second,first + nums[i] * i);
            first = second;
            second = tmp;
        }

        return second;
    }
}
