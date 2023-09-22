package 二叉树;

/**
 * @ClassName 面试题_04_02_最小高度树
 * @Author zxf
 * @Date 2023/1/13 13:13
 **/
public class 面试题_04_02_最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return  dfs(nums,0,nums.length - 1);

    }

    private TreeNode dfs(int[] nums,int left,int right){
        if(nums == null || nums.length == 0 || left > right) return null;

        int mid = (right - left) / 2 + left;

        TreeNode l = dfs(nums,left,mid-1);
        TreeNode r =  dfs(nums,mid+1,right);

        return new TreeNode(nums[mid],l,r);
    }
}
