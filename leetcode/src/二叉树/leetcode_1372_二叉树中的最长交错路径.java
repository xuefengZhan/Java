package 二叉树;

/**
 * @ClassName leetcode_1372_二叉树中的最长交错路径
 * @Author zxf
 * @Date 2024/1/8 9:07
 * @Questinon Describrition
 **/
public class leetcode_1372_二叉树中的最长交错路径 {
    public int longestZigZag(TreeNode root) {
        dfs(root,false);
        return res;
    }


    int res = 0;


    //以当前节点为出发节点的最大交叉路经
//    private int[] dfs(TreeNode node,int position) {
//        if (node == null) return new int[]{-1, -1};
//
//        //左子节点
//        int[] left = dfs(node.left, -1);
//        int[] right = dfs(node.right, 1);
//
//
//        res = Math.max(res, right[0] + 1);
//        res = Math.max(res, left[1] + 1);
//
//        //当前节点是左边
//        if (position == -1) {
//            return new int[]{0, right[0] + 1};
//        } else if (position == 1) {
//            return new int[]{left[1] + 1, 0};
//        } else {
//            return new int[]{left[1] + 1, right[0] + 1};
//        }
//    }


    /**
     * 优化：上面虽然用数组保存结果 但只用到了left[1] 和 right[0]
     *
     * @param node 当前节点
     * @param left 当前节点是否是左子节点
     * @return 以当前节点为出发点的交叉路经长度
     */
    private int dfs(TreeNode node,boolean left) {
        if (node == null) return -1;

        //左子节点
        int l = dfs(node.left, true) + 1;
        int r = dfs(node.right, false) + 1;


        res = Math.max(res,l);
        res = Math.max(res,r);


        //如果当前节点是左子节点 则返回右子节点结果+1
        return left? r : l ;
    }
}



