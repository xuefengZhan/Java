package 二叉树;

/**
 * @ClassName leetcode_700_二叉搜索树中的搜索
 * @Author zxf
 * @Date 2023/1/11 14:36
 **/
public class leetcode_700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;

        if(root.val == val) return root;

        if(root.val > val) return searchBST(root.left,val);

        return searchBST(root.right,val);
    }
}
