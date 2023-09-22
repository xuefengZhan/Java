package 回溯;

import java.util.ArrayList;
import java.util.List;

public class leetcode_491_递增子序列 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(new ArrayList<Integer>(),-101,0,nums);

        return res;
    }

    private void dfs(ArrayList<Integer> path,int lastNum,int index,int[] nums){
        if(path.size() >= 2){
            res.add(new ArrayList<>(path));
        }

        if(index >= nums.length) return;

        for(int i = index;i<nums.length;i++){
            if(nums[i] < lastNum) continue;
            if(i > index && nums[i] == nums[i - 1]) continue;

            path.add(nums[i]);

            dfs(path,nums[i],i+1,nums);

            path.remove(path.size() - 1);

        }
    }


    public static void main(String[] args) {
        leetcode_491_递增子序列 v = new leetcode_491_递增子序列();
        int[] nums = {4,6,7,7};
        List<List<Integer>> subsequences = v.findSubsequences(nums);

        System.out.println(subsequences);
    }
}
