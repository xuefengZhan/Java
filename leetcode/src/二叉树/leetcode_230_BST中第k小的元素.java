package 二叉树;

/**
 * @ClassName leetcode_230_BST中第k小的元素
 * @Author zxf
 * @Date 2023/2/6 18:33
 **/
public class leetcode_230_BST中第k小的元素 {
    int x = 1;
    int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }


    private void dfs(TreeNode root,int k){
        if(x > k || root == null) return ;

        dfs(root.left,k);

        if(x++ == k){
            res =  root.val;
        }

        dfs(root.right,k);
    }
}
