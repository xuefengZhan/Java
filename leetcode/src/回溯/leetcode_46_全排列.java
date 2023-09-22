package 回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class leetcode_46_全排列 {

//    List<List<Integer>> res = new ArrayList<>();
//    public List<List<Integer>> permute(int[] nums) {
//
//
//        place(new ArrayList<Integer>() ,nums,new HashSet<Integer>());
//        return res;
//    }
//
//    private void place(ArrayList<Integer>  path,int[] nums,HashSet<Integer> usedEle){
//        if(path.size() == nums.length) {
//            res.add(new ArrayList<Integer>(path));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            //剪枝
//            if(usedEle.contains(nums[i])) continue;
//
//            //path[index] 做选择
//            path.add(nums[i]);
//            usedEle.add(nums[i]);
//
//            //递归 path[index + 1]
//            place(path,nums,usedEle);
//
//            //回溯 当前的选择
//            path.remove(path.size() - 1);
//            usedEle.remove(nums[i]);
//
//        }
//
//    }
//

    List<List<Integer>> res = new ArrayList<>();
    //1 <= nums.length <= 6
    //-10 <= nums[i] <= 10
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return res;
        dfs(nums,new int[21],new ArrayList<Integer>());

        return res;
    }

    private void dfs(int[] nums,int[] visited,List<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[nums[i]] == 1) continue; //

            path.add(nums[i]);
            visited[nums[i]] = 1;

            dfs(nums,visited,path);

            //回到选择前的状态
            path.remove(path.size() - 1);
            visited[nums[i]] = 0;
        }
    }

    public static void main(String[] args) {
        leetcode_46_全排列 v = new leetcode_46_全排列();
        int[] nums = {1};
        List<List<Integer>> res = v.permute(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
