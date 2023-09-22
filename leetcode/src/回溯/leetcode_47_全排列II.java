package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */

public class leetcode_47_全排列II {

        List<List<Integer>> res = new ArrayList();
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            dfs(nums,new ArrayList<Integer>(),new boolean[nums.length]);

            return res;
        }

        private void dfs(int[] nums,List<Integer> list,boolean[] choosed){
            if(list.size() == nums.length){
                res.add(new ArrayList(list));
                return;
            }

            //做当下的选择
            int choose = 100;
            for(int i = 0;i<nums.length;i++){
                // 选的和上一次选的是一样的就跳过去
                if(nums[i] == choose || choosed[i]) continue;

                choose = nums[i];

                choosed[i] = true;

                list.add(nums[i]);
                dfs(nums,list,choosed);
                list.remove(list.size() - 1);

                choosed[i] = false;
            }
        }


    public static void main(String[] args) {
        leetcode_47_全排列II v = new leetcode_47_全排列II();

        int[] nums = {1,1,2};
        List<List<Integer>> res = v.permuteUnique(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
