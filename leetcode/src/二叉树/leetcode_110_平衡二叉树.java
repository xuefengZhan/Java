package 二叉树;

/**
 * @ClassName leetcode_110_平衡二叉树
 * @Author zxf
 * @Date 2023/1/13 9:29
 **/
public class leetcode_110_平衡二叉树 {
    boolean res = true;
    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return res;
    }

    private int getHeight(TreeNode node){
        if(node == null) return 0;
        if(!res) return -1;

        int left = getHeight(node.left);
        int right =getHeight(node.right);

        if(Math.abs(left - right) > 1) res = false;

        return Math.max(left,right) + 1;
    }
}
