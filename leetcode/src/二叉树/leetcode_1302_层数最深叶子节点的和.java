package 二叉树;

/**
 * @ClassName leetcode_1302_层数最深叶子节点的和
 * @Author zxf
 * @Date 2024/1/3 13:56
 * @Questinon Describrition
 **/
public class leetcode_1302_层数最深叶子节点的和 {
    int maxLevel = 0;
    int res = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root,0);
        return res;
    }


    private void dfs(TreeNode node , int level){
        if(node == null) return;

        if(level > maxLevel){
            res = node.val;
            maxLevel = level;
        }else if(level == maxLevel){
            res += node.val;
        }

        dfs(node.left,level+1);
        dfs(node.right,level+1);
    }
}
