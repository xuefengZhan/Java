package 二叉树;

public class leetcode_572_另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;

        return isSame(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

     }


     private boolean isSame(TreeNode t1,TreeNode t2){
        if(t1 == null  && t2 == null) return true;
        if(t1 == null || t2 == null) return false;

        if(t1.val != t2.val) return false;

        return isSame(t1.left,t2.left) && isSame(t1.right,t2.right);
     }
}
