package 二叉树;

public class leetcode_563_二叉树的坡度 {
    int res = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }

    //求和
    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        res += Math.abs(left - right);

        return left + right + root.val;

    }
}
