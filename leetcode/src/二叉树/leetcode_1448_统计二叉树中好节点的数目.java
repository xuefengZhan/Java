package 二叉树;

/**
 * @ClassName leetcode_1448_统计二叉树中好节点的数目
 * @Author zxf
 * @Date 2024/1/9 10:22
 * @Questinon Describrition
 **/
public class leetcode_1448_统计二叉树中好节点的数目 {
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,Integer.MIN_VALUE);
        return res;
    }

    /**
     *
     * @param node 当前节点
     * @param max  到达当前节点前的路径上的最大值
     */
    private void dfs(TreeNode node,int max){
        if(node == null) return ;

        if(max <= node.val){
            res++;
        }

        max = Math.max(max,node.val);
        dfs(node.left,max);
        dfs(node.right,max);
    }
}
