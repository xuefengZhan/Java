package 二叉树;

/**
 * @ClassName offer_28_对称的二叉树
 * @Author zxf
 * @Date 2023/1/13 9:10
 *
 * 本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 **/
public class offer_28_对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return isSym(root.left,root.right);
    }


    private boolean isSym(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null) return true;

        if(t1 == null || t2 == null) return false;

        if(t1.val != t2.val) return false;

        return isSym(t1.left,t2.right) && isSym(t1.right,t2.left);
    }
}
