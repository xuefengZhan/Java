package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40_数组总和2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        Arrays.sort(candidates);
        place(new ArrayList<Integer>(),0,candidates,target,0);

        return res;

    }

    private void place(List<Integer> path, int pathSum, int[] candidates, int target, int start){
        if(pathSum > target) return;
        if(pathSum == target){
            ArrayList<Integer> line = new ArrayList<>(path);
            res.add(line);
            return;
        }

        //这个for循环除去递归部分，本质上是在给path[index]选择元素，
        //从candidates[start] 开始选择，但是不能重复
        for (int i = start; i < candidates.length; i++) {

            if(candidates[i] > target - pathSum) continue;

             // 1 1 2 5 6 7 10
            if(i > start && candidates[i] == candidates[start]) continue;

            //给path[index]选择元素
            path.add(candidates[i]);
            pathSum += candidates[i];

            start = i +1;

            //给path[index + 1] 选择元素
            place(path,pathSum,candidates,target,start);

            //回溯  path[index]为当前状况下，path[index + 1] 及path[index + n]都尝试完了
            //给path[index]做另外的选择
            Integer last = path.get(path.size() - 1);
            pathSum -= last;
            path.remove(path.size() - 1);
            start--; //start 必须--，因为path[index] 就是从start选起的，需要保证candidates[start + n] 不能后candidates[start] 重复
            //i ++;

        }
    }

    public static void main(String[] args) {
        No40_数组总和2 v = new No40_数组总和2();
        int[] candidates = {10,1,2,7,6,1,5}; // 1 1 2 5 6 7 10
        int target = 8;
        List<List<Integer>> lists = v.combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
