package 二叉树;

public class leetcode_100_相同的树 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != null && q != null && p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        if(p == null && q == null) return true;

        return false;
    }
}
