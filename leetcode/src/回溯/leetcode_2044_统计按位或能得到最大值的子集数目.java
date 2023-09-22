package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 *https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 *
 * mid
 */
public class leetcode_2044_统计按位或能得到最大值的子集数目 {
    int tmp = 0;
    List<List<Integer>> Paths = new ArrayList<>();
    public int countMaxOrSubsets(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res | nums[i];
        }



        dfs(nums,0,new ArrayList<Integer>(),0,res);
        System.out.println(Paths);
        return tmp;
    }

    private void dfs(int[] chooses, int start, List<Integer> path,int pathRes,int target){
        if(pathRes == target){
            tmp += 1;
            Paths.add(new ArrayList<>(path));
        }
        if(start == chooses.length) return;
        //给当前path的做选择
        for (int i = start; i < chooses.length; i++) {
             path.add(chooses[i]);
             int temp = pathRes;
             dfs(chooses,i+1,path,pathRes|chooses[i],target);
             path.remove(path.size() - 1);
             pathRes = temp;
        }
    }

    public static void main(String[] args) {
        leetcode_2044_统计按位或能得到最大值的子集数目 v = new leetcode_2044_统计按位或能得到最大值的子集数目();
        int[] nums = {3,2,1,5};
        int res = v.countMaxOrSubsets(nums);
        System.out.println(res);
    }
}
