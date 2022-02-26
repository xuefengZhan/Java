package 回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No46_全排列3 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        if(nums == null || nums.length == 0) return res;

        place(nums,new ArrayList<Integer>(),new HashSet<Integer>());

        return res;

    }

    private void place(int[] chooses,List<Integer> path, Set<Integer> choosed){
        if(path.size() == chooses.length){
            res.add(new ArrayList<>(path));
            return;
        }


        for (int i = 0; i < chooses.length; i++) {
            if(choosed.contains(i)) continue;

            path.add(chooses[i]);
            choosed.add(i);

            place(chooses,path,choosed);

            path.remove(path.size() - 1);
            choosed.remove(i);
        }
    }

    public static void main(String[] args) {
        No46_全排列3 v = new No46_全排列3();
        int[] nums = {1,2,3};
        List<List<Integer>> res = v.permute(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

}
