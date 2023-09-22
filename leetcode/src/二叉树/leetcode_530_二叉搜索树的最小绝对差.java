package 二叉树;

public class leetcode_530_二叉搜索树的最小绝对差 {
    int min = Integer.MIN_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return min;
    }
    TreeNode prev = null;
    private void dfs(TreeNode root){
        if(root == null) return;

        dfs(root.left);
        if(prev == null){
            prev = root;
        }else{
            min = Math.min(root.val - prev.val,min);
            prev = root;
        }
        dfs(root.right);
    }


}
