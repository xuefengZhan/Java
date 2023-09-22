package 二叉树;

public class leetcode_404_左叶子之和 {
    int res = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        if(root == null) return 0;

        dfs(root,null);

        return res;
    }


    private void dfs(TreeNode cur,TreeNode parent){
        if(cur == null) return;
        if(cur.left == null && cur.right == null){
            if(parent != null &&  cur == parent.left){
                res += cur.val;
            }
            return;
        }
        if(cur.left != null){
            dfs(cur.left,cur);
        }
        if(cur.right != null){
            dfs(cur.right,cur);
        }
    }
}
