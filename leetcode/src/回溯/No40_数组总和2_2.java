package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40_数组总和2_2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        place(candidates,0,new ArrayList<Integer>(),0,target);

        return res;
    }

    /**
     * 给path的第index个元素选择
     * @param chooses
     * @param path
     * @param pathSum
     * @param target
     */
    private void place(int[] chooses,int start,List<Integer> path,int pathSum,int target){
        if(pathSum > target){
            return;
        }
        if(pathSum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i =  start; i < chooses.length; i++) {

            // chooses[i] == chooses[i-1] 避免当前选到一样的
            // i > start :下一轮的start - 1 是当前的i ,因此 i > start 指的是当前轮start后面的元素
            if(i > start && chooses[i] == chooses[i-1]) continue;
//            if(i > start && chooses[i] == chooses[start]) continue;
            if(target - pathSum < chooses[i]) break;

            path.add(chooses[i]);

            //下一层做选择
            place(chooses,i+1,path,pathSum+chooses[i],target);
            path.remove(path.size()-1);

        }
    }

    public static void main(String[] args) {
        No40_数组总和2_2 v = new No40_数组总和2_2();
        int[] candidates= {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> res = v.combinationSum2(candidates, target);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
