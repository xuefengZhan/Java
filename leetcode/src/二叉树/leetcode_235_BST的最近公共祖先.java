package 二叉树;

/**
 * @ClassName leetcode_235_BST的最近公共祖先
 * @Author zxf
 * @Date 2023/2/6 18:50
 **/
public class leetcode_235_BST的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val) return root;

        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }
}
