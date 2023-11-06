package 二叉树;

/**
 * @ClassName leetcode_1026_节点与其祖先之间的最大差值
 * @Author zxf
 * @Date 2023/10/11 14:47
 * @Questinon Describrition
 **/
public class leetcode_1026_节点与其祖先之间的最大差值 {
    int res = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root,root.val,root.val);
        return res;
    }

    private void dfs(TreeNode node,int min,int max){
        if(node == null) return;

        min = Math.min(min,node.val);
        max = Math.max(max,node.val);

        res = Math.max(max - min,res);

        dfs(node.left,min,max);
        dfs(node.right,min,max);
    }
}
