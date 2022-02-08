package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 */
public class No78_子集 {


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        for (int i = 0; i <= nums.length; i++) {
            place(i,nums,0,new ArrayList<Integer>());
        }

        return res;
    }


    private void place(int size,int[] nums,int start,List<Integer> path){
        if(path.size() == size){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);

            place(size,nums,++i,path);

            i--;
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        No78_子集 v = new No78_子集();
        int[] arr = {1,2,3};
        List<List<Integer>> res = v.subsets(arr);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }
}
