package dp.打家劫舍;

/**
 * @ClassName leetcode_213_打家劫舍II
 * @Author zxf
 * @Date 2023/8/30 9:27
 * @Questinon Describrition
 *
 *
 * 2ms
 **/
public class leetcode_213_打家劫舍II {
//    public int rob(int[] nums) {
//        int n1 = nums[0];
//        int n2 = nums[nums.length - 1];
//
//        nums[0] = 0;
//        int r1 = help(nums);
//        nums[0] = n1;
//
//        nums[nums.length - 1] = 0;
//        int r2 = help(nums);
//        nums[nums.length - 1] = n2;
//
//        return Math.max(r1,r2);
//    }
//
//
//    private int help(int[] nums){
//        int[] dp = new int[nums.length + 1];
//
//        dp[0] = 0;
//        dp[1] = nums[0];
//
//        for (int i = 2; i <= nums.length; i++) {
//             dp[i] = Math.max(dp[i-2] + nums[i - 1],dp[i-1]);
//        }
//
//        System.out.println(Arrays.toString(dp));
//        return dp[dp.length - 1];
//    }


    /**
     * 官方解法  思路时一样的  这个更清晰
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0],nums[1]);


        int r1 = help(nums,1,nums.length-1);
        int r2 = help(nums,0,nums.length-2);

        return Math.max(r1,r2);
    }


    private int help(int[] nums,int l ,int r){
        int prev = 0;
        int aft = 0;

        for (int i = l; i <= r; i++) {
            int tmp = Math.max(prev + nums[i],aft);
            prev = aft;
            aft = tmp;
        }

        return aft;
    }

    public static void main(String[] args) {
        leetcode_213_打家劫舍II v = new leetcode_213_打家劫舍II();

        int[] nums = {1,2,3};

        int rob = v.rob(nums);
        System.out.println(rob);
    }



}
