package 二叉树;

/**
 * @Date 2023/11/10 1:02
 * @Author 詹学丰
 * @Name leetcode_687_最长同值路径
 * @QUESTION DESCRIPTION
 * @TAG
 * @RESULT
 **/

public class leetcode_687_最长同值路径 {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return res;
    }


    private int dfs(TreeNode node){
        if(node == null) return 0;

        if(node.left == null && node.right == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int l = 0;
        int r = 0;
        if(node.left != null && node.left.val == node.val){
            l = left + 1;
        }

        if(node.right != null && node.right.val == node.val){
            r = right + 1;
        }

        res = Math.max(l + r,res);
        return Math.max(l,r);
    }
}
