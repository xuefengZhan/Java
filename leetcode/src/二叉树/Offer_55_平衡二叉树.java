package 二叉树;

/**
 *  和leetcode_110是一样的
 */
public class Offer_55_平衡二叉树 {

    /**
     * 60.98%
     */

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node){
        if(node == null) return 0;

        return Math.max(height(node.left),height(node.right)) + 1;

    }
}
