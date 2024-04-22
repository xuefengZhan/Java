package 二叉树;

/**
 * @ClassName leetcode_865_具有所有最深节点的最小子树
 * @Author zxf
 * @Date 2023/11/14 11:51
 * @Questinon Describrition
 *
 *
 * 后序遍历的经典应用  这题要多看  和1123是一样的题目
 **/
public class leetcode_865_具有所有最深节点的最小子树 {

    private class info{
        TreeNode node;
        int deepth;
        public info(){};
        public info(TreeNode node,int deepth){
            this.node = node;
            this.deepth = deepth;
        }

        public TreeNode getNode() {
            return node;
        }

        public int getDeepth() {
            return deepth;
        }
    }

    private info dfs(TreeNode node,int deepth){
        if(node == null) return new info(null,-1);
        if(node.left == null && node.right == null){
            return new info(node,deepth);
        }


        info left = dfs(node.left, deepth + 1);
        info right = dfs(node.right, deepth + 1);


        if(left.getDeepth() == right.getDeepth()){
            return new info(node,left.getDeepth());
        }else if(left.getDeepth() > right.getDeepth()){
            return left;
        }else{
            return right;
        }

    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root,0).getNode();
    }
}
