package 二叉树;

/**
 * @ClassName leetcode_98_验证二叉搜索树
 * @Author zxf
 * @Date 2023/2/2 13:53
 **/
public class leetcode_98_验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return dfs(Long.MIN_VALUE,Long.MAX_VALUE,root);
    }

    private boolean dfs(long min,long max,TreeNode root){
        if(root == null) return true;
        if(root.val <= min) return false;
        if(root.val >= max) return false;

        return dfs(min,root.val,root.left) && dfs(root.val,max,root.right);
    }
}
