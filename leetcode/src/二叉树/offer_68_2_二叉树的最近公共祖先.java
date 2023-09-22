package 二叉树;

/**
 * @ClassName offer_68_2_二叉树的最近公共祖先
 * @Author zxf
 * @Date 2023/1/13 12:00
 **/
public class offer_68_2_二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //自顶向下考虑
        if(root == null || root == p || root == q) return root;

        TreeNode right = lowestCommonAncestor(root.right,p,q);
        TreeNode left = lowestCommonAncestor(root.left,p,q);

        if(left != null && right != null) return root;
        return right == null ? left : right;
    }
}
