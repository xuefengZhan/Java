package 二叉树;

/**
 * @ClassName offer_68_二叉搜索树的最近公共祖先
 * @Author zxf
 * @Date 2023/1/13 9:40
 **/
public class offer_68_二叉搜索树的最近公共祖先 {
    //自顶向下
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;


        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,q,p);
        }
        return root;
    }
}
