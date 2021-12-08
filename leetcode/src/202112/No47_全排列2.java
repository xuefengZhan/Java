import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 *
 * https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */

public class No47_全排列2 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        place(new ArrayList<Integer>(),nums,0,new HashSet<Integer>());

        return res;
    }


    //path[index] 放置元素 ，nums中用过的索引就不要再用了
    private void place(List<Integer> path,int[] nums,int start,HashSet<Integer> usedIndex){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        //path[index] 做选择
        HashSet<Integer> usedNum = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            // 剪枝1 path[index - n] 选择过的不可以选，这里存储的是选择过的元素的index
            if(usedIndex.contains(i)) continue;
            // 剪枝2 usedNum中包含的不可以选
            if(usedNum.contains(nums[i])) continue;

            // 选择
            path.add(nums[i]);
            usedIndex.add(i);
            usedNum.add(nums[i]);

            //递归
            place(path,nums,start + 1,usedIndex);

            //回溯 path[index] 重新做选择
            path.remove(path.size() - 1);
            usedIndex.remove(i);

        }
    }

    public static void main(String[] args) {
        No47_全排列2 v = new No47_全排列2();

        int[] nums = {1,1,2};
        List<List<Integer>> res = v.permuteUnique(nums);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
