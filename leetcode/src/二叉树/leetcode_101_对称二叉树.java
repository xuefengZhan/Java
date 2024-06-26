package 二叉树;

public class leetcode_101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;
        if(t1 != null && t2 != null){
            if(t1.val != t2.val) return false;
            return isSymmetric(t1.right,t2.left) && isSymmetric(t1.left,t2.right);
        }
        return false;
    }
}
