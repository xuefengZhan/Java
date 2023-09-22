package 二叉树;

/**
 * @ClassName 面试题_04_04_检查平衡性
 * @Author zxf
 * @Date 2023/1/13 16:15
 *
 * 和leetcode_110题是一样的
 *
 * 这种写法效率低
 **/
public class 面试题_04_04_检查平衡性 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode node){
        if(node == null) return 0;

        return Math.max(height(node.left),height(node.right)) + 1;

    }
}
