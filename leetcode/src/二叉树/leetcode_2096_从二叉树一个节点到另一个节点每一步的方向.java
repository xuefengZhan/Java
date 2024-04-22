package 二叉树;

/**
 * @ClassName leetcode_2096_从二叉树一个节点到另一个节点每一步的方向
 * @Author zxf
 * @Date 2024/1/18 10:01
 * @Questinon Describrition
 **/
public class leetcode_2096_从二叉树一个节点到另一个节点每一步的方向 {
    StringBuilder sb1;
    StringBuilder sb2 ;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode node = dfs(root, startValue, destValue);
        dfs1(node,startValue);
        dfs2(node,destValue);
        return sb1.append(sb2).toString();
    }


    //最小公共父节点
    //如果在存在父子关系 直接从父节点返回了
    private TreeNode dfs(TreeNode node,int p,int q){
        if(node == null) return null;
        if(node.val == p){
            return node;
        }
        if(node.val == q){
            return node;
        }

        TreeNode left = dfs(node.left,p,q);
        TreeNode right = dfs(node.right,p,q);

        if(left == null && right == null) return null;
        if(left != null && right != null) return node;
        return left == null ? right : left;
    }

    /**
     *
     * @param node   起始节点
     * @param p      目标节点
     * @return
     */

    private TreeNode dfs1(TreeNode node,int p){


        if(node == null) return null;

        if(node.val == p){
            sb1 = new StringBuilder();
            return node ;
        }


        TreeNode left = dfs1(node.left, p);
        TreeNode right = dfs1(node.right, p);

        if(left == null && right == null) return null;

        sb1.append("U");

        return left != null ? left :right;
    }


    private TreeNode dfs2(TreeNode node,int q){
        if(node == null) return null;
        if(node.val == q){
            sb2  = new StringBuilder();
            return node ;
        }

        TreeNode left = dfs2(node.left, q);
        TreeNode right = dfs2(node.right, q);

        if(left == null && right == null) return null;

        if(left != null){
            sb2.insert(0,"L");
            return left;
        }else{
            sb2.insert(0,"R") ;
            return right;
        }
    }

}
