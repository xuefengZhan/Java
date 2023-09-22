package 二叉树;

/**
 * @ClassName leetcode_1123_最深叶节点的最近公共祖先
 * @Author zxf
 * @Date 2023/9/6 11:36
 * @Questinon Describrition
 **/
public class leetcode_1123_最深叶节点的最近公共祖先 {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
          info res = dfs(root,0);
          return res.node;
    }

    private class info{
        TreeNode node;
        int deepth;

        public info(){};
        public info(TreeNode node,int deepth){
            this.node = node;
            this.deepth = deepth;
        }
    }

    private info dfs(TreeNode root,int deepth){
        if(root == null){
            return new info(null,0);
        }

        //叶子结点
        if(root.left == null && root.right == null){
            return new info(root,deepth);
        }

        info left = dfs(root.left,deepth + 1);
        info right = dfs(root.right,deepth + 1);

        //如果左右不一般高，返回低的那个
        if(left.deepth > right.deepth){
            return left;
        }else if(left.deepth < right.deepth){
            return right;
        }else{
            return new info(root,deepth);
        }
    }
}
