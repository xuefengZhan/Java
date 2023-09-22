package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_39_组合总和
 * @Author zxf
 * @Date 2023/8/10 10:24
 *
 *  无重复元素 ， 元素可重复选择 ， 组合不能重复
 **/
public class leetcode_39_组合总和 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return null;

        dfs(candidates,0,new ArrayList<>(),target);

        return res;
    }


    private void dfs(int[] candidates,int start,List<Integer> path,int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i = start; i < candidates.length; i++) {
            if(candidates[i] > target) continue;

            path.add(candidates[i]);

            dfs(candidates,i,path,target - candidates[i]);

            path.remove(path.size() - 1);
        }
    }
}
