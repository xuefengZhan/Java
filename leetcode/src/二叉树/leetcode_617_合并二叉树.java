package 二叉树;

public class leetcode_617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;

        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }

        return new TreeNode(root1.val + root2.val,mergeTrees(root1.left,root2.left),mergeTrees(root1.right,root2.right));
    }
}
