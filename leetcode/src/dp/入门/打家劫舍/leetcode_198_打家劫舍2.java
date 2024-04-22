package dp.入门.打家劫舍;

/**
 * @ClassName leetcode_198_打家劫舍
 * @Author zxf
 * @Date 2023/8/29 18:29
 * @Questinon Describrition
 *
 * 递归写法 这里可以优化一下 用记忆化搜索
 **/
public class leetcode_198_打家劫舍2 {
    public int rob(int[] nums) {
        return dfs(nums,nums.length - 1);
    }




    private int dfs(int[] nums,int n){
        if(n < 0) return 0;

        int prev = dfs(nums, n - 1);
        int cur = dfs(nums,n-2) + nums[n];

        return Math.max(cur,prev);
    }

    public static void main(String[] args) {
        leetcode_198_打家劫舍2 v = new leetcode_198_打家劫舍2();
        int[] nums = {2,7,9,3,1};

        int rob = v.rob(nums);

        System.out.println(rob);
    }
}


