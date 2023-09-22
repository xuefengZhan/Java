package 二叉树;

/**
 * @ClassName leetcode_965_单值二叉树
 * @Author zxf
 * @Date 2023/1/12 9:46
 **/
public class leetcode_965_单值二叉树 {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;

        boolean left = true;
        boolean right = true;
        if(root.left != null){
            left = isUnivalTree(root.left) && root.val == root.left.val;
        }
        if(root.right != null){
            right = isUnivalTree(root.right) && root.val == root.right.val;
        }
        return  left && right;
    }
}
