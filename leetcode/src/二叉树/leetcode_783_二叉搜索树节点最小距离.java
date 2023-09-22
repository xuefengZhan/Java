package 二叉树;

/**
 * @ClassName leetcode_783_二叉搜索树节点最小距离
 * @Author zxf
 * @Date 2023/1/11 19:24
 *
 * 和530是一样的
 **/
public class leetcode_783_二叉搜索树节点最小距离 {
    int prev = -1;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode node){
        if(node == null) return;

        dfs(node.left);

        if(prev == -1){
            prev = node.val;
        }else{
            min = Math.min(node.val - prev,min);
            prev = node.val;
        }

        dfs(node.right);
    }
}
