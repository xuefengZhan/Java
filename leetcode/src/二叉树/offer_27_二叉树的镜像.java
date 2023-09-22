package 二叉树;

/**
 * @ClassName offer_27_二叉树的镜像
 * @Author zxf
 * @Date 2023/1/13 9:06
 *
 * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 **/
public class offer_27_二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {

        if(root == null) return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }
}
