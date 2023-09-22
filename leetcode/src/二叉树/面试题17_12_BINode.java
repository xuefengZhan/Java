package 二叉树;

/**
 * @ClassName 面试题17_12_BINode
 * @Author zxf
 * @Date 2023/1/13 16:24
 *
 *  和leetcpde_897是一样的
 **/
public class 面试题17_12_BINode {
    TreeNode head = new TreeNode(-1);
    TreeNode prev = head;

    public TreeNode convertBiNode(TreeNode root) {

            if(root == null) return null;

            convertBiNode(root.left);

            root.left = null;
            prev.right = root;
            prev = prev.right;

            convertBiNode(root.right);


            return head.right;
    }
}
