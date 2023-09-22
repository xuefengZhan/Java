package 二叉树;

/**
 * @ClassName leecode_2331_计算布尔二叉树的值
 * @Author zxf
 * @Date 2023/2/6 9:05
 **/
public class leecode_2331_计算布尔二叉树的值 {
    public boolean evaluateTree(TreeNode root) {

        if(root.val == 1) return true;
        if(root.val == 0) return false;

        if(root.val == 2) return evaluateTree(root.left) || evaluateTree(root.right);
        return evaluateTree(root.left) && evaluateTree(root.right);
    }
}
