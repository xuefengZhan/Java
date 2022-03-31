package 回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class No46_全排列 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {


        place(new ArrayList<Integer>() ,nums,new HashSet<Integer>());
        return res;
    }

    private void place(ArrayList<Integer>  path,int[] nums,HashSet<Integer> usedEle){
        if(path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if(usedEle.contains(nums[i])) continue;

            //path[index] 做选择
            path.add(nums[i]);
            usedEle.add(nums[i]);

            //递归 path[index + 1]
            place(path,nums,usedEle);

            //回溯 当前的选择
            path.remove(path.size() - 1);
            usedEle.remove(nums[i]);

        }

    }

    public static void main(String[] args) {
        No46_全排列 v = new No46_全排列();
        int[] nums = {1};
        List<List<Integer>> res = v.permute(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
