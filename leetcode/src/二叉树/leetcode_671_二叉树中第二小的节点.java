package 二叉树;

/**
 * @ClassName leetcode_671_二叉树中第二小的节点
 * @Author zxf
 * @Date 2023/1/11 12:16
 **/
public class leetcode_671_二叉树中第二小的节点 {

    int min ;
    long secondMin = Long.MAX_VALUE  ;
    public int findSecondMinimumValue(TreeNode root) {
        min = root.val;


        dfs(root);

        return secondMin == Long.MAX_VALUE ? -1 : (int) secondMin;
    }

    private void dfs(TreeNode root){
        if(root == null) return;

        if(root.val > min){
            secondMin = Math.min(root.val,secondMin);
        }

        dfs(root.left);
        dfs(root.right);
    }
}
