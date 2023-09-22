package 二叉树;

/**
 * @ClassName leetcode_236_二叉树的最近公共祖先
 * @Author zxf
 * @Date 2023/2/6 19:03
 *
 * 后序遍历
 **/
public class leetcode_236_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        //p 和 q 分别在左右子树中
        if(left != null && right != null) return root;
        //有一边为null 则 p 和 q在某棵子树中
        return left == null ? right : left;
    }
}
