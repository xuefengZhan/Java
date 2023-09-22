package 二叉树;

/**
 * @ClassName leetcode_99_恢复二叉搜索树
 * @Author zxf
 * @Date 2023/2/2 17:20
 **/
public class leetcode_99_恢复二叉搜索树 {
    TreeNode prev;
    TreeNode cur;

    TreeNode t1;
    TreeNode t2;

    int first;
    int last;

    public void recoverTree(TreeNode root) {
        dfs(root);

        t1.val = last;
        t2.val = first;
    }

    private void dfs(TreeNode root){
        dfs(root.left);
        if(prev == null){
            prev = root;
        }else{
            cur = root;
            if(prev.val > cur.val){
                if(t1 == null){
                    t1 = prev;
                    first = prev.val;
                }
                t2 = cur;
                last = cur.val;
            }
            prev = root;
        }
        dfs(root.right);
    }
}
