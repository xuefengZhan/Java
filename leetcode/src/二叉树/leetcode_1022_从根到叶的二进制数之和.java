package 二叉树;

/**
 * @ClassName leetcode_1022_从根到叶的二进制数之和
 * @Author zxf
 * @Date 2023/1/12 10:27
 **/
public class leetcode_1022_从根到叶的二进制数之和 {

    private int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root,0);
        return res;
    }

    // sum是父节点的和，当前node的值没有算进去
    private void dfs(TreeNode node,int sum){
        if(node == null) return;

        //叶子结点
        if(node.left == null && node.right == null){
            res += (sum << 1) + node.val;
            return ;
        }

        dfs(node.left,(sum << 1) + node.val);
        dfs(node.right,(sum << 1) + node.val);

    }
}
