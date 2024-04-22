package 二叉树;

/**
 * @ClassName LCR_051_二叉树中的最大路径和
 * @Author zxf
 * @Date 2024/3/4 9:15
 * @Questinon Describrition
 **/
public class LCR_051_二叉树中的最大路径和 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }


    //返回当前节点的最大边
    private int dfs(TreeNode node){

        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);




        if(left <= 0) left = 0;
        if(right <= 0) right = 0;

        //以node为根节点的最大路径
        res = Math.max(left + right + node.val,res);

        return Math.max(left,right) + node.val;
    }
}
