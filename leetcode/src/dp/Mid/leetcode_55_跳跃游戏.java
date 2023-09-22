package dp.Mid;

/**
 * @ClassName leetcode_55_跳跃游戏
 * @Author zxf
 * @Date 2023/8/24 11:18
 * @Questinon Describrition
 **/
public class leetcode_55_跳跃游戏 {


    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxPosition = 0;
        int end = 0;


        for (int i = 0; i < n ; i++) {
            maxPosition = Math.max(maxPosition,i+nums[i]);

            if(i == end){
                end = maxPosition; //下一阶段能到达的最大位置
                if(end >= n - 1){
                    return true;
                }
            }
        }

        return false;
    }

}
