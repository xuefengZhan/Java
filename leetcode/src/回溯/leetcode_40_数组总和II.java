package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_40_数组总和II {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return null;

        Arrays.sort(candidates);
        dfs(candidates,0,new ArrayList<>(),target);
        return res;
    }


    //todo 排序 + start 的目的 path[index+n]的元素不能选path[index]选过的
    private void dfs(int[] candidates,int start,ArrayList<Integer> path,int target){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        // todo 同一位置不能选择同一个元素
        int choose = -1;
        for (int i = start; i < candidates.length; i++) {
            if(choose == candidates[i] || target < candidates[i]) continue;

            path.add(candidates[i]);
            choose = candidates[i];

            dfs(candidates,i+1,path,target - candidates[i]);

            path.remove(path.size() - 1);

        }

    }

}
