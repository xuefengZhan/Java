package 二叉树;

/**
 * @ClassName leetcode_993_二叉树的堂兄弟节点
 * @Author zxf
 * @Date 2023/1/12 10:00
 **/
public class leetcode_993_二叉树的堂兄弟节点 {
    //1.深度相同
    //2.父节点不同
    int xd = -1;
    int yd = -1;
    TreeNode xp = null;
    TreeNode yp = null;

    public boolean isCousins(TreeNode root, int x, int y) {
            dfs(root,x,y,0,null);
            return xp != yp && xd == yd;
    }


    private void dfs(TreeNode root,int x,int y,int deepth,TreeNode parent){
        if(xd != -1 && yd != -1) return;

        if(root == null) return;

        if(root.val == x){
            xd = deepth;
            xp = parent;
        }

        if(root.val == y){
            yd = deepth;
            yp = parent;
        }

        dfs(root.left,x,y,deepth+1,root);
        dfs(root.right,x,y,deepth+1,root);
    }
}
