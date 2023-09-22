package 二叉树;

public class leetcode_226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
