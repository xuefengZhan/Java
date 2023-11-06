package 二叉树;

/**
 * @ClassName leetcode_124_二叉树中的最大路径和
 * @Author zxf
 * @Date 2023/10/9 10:53
 * @Questinon Describrition
 *
 * hard
 *
 * 递归过程中 求全局最值
 **/
public class leetcode_124_二叉树中的最大路径和 {
    int res = 0;

    public int maxPathSum(TreeNode root) {
        if(root == null) return res;

        dfs(root);

        return res;
    }


    //当前节点作为根节点的最大边的路径和
    private int dfs(TreeNode node){
        if(node == null) return 0;

        //左子节点的最大边
        int left = dfs(node.left) ;
        //右子节点最大边
        int right = dfs(node.right);

        int cur = node.val;
        if(left > 0) cur += left;
        if(right > 0) cur += right;

        res = Math.max(res,cur);

        //如果左右子边都小于0 则都不加
        return Math.max(Math.max(left, right),0)  +  node.val;
    }


}

