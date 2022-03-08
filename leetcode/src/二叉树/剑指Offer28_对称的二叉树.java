package 二叉树;

/**
 * https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 *
 * easy
 */
public class 剑指Offer28_对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSym(root.left,root.right);
    }

    private boolean isSym(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null ) return true;
        if(t1 == null || t2 == null) return false;

        if(t1.val != t2.val) return false;

        return isSym(t1.left,t2.right) && isSym(t1.right,t2.left);
    }
}
