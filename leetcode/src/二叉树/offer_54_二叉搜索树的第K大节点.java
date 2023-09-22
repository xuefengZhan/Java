package 二叉树;

/**
 * @ClassName offer_54_二叉搜索树的第K大节点
 * @Author zxf
 * @Date 2023/1/13 9:17
 **/
public class offer_54_二叉搜索树的第K大节点 {
    int num;
    int k;
    int res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode node){
        if(node == null) return ;
        //提前返回
        if(num == k) return;

        dfs(node.right);
        if(++num == k){
            res = node.val;
        }
        dfs(node.left);
    }

}
