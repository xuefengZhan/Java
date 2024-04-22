package 二叉树;

/**
 * @ClassName leetcode_1080_根到叶路径上的不足节点
 * @Author zxf
 * @Date 2023/12/4 9:26
 * @Questinon Describrition
 **/
public class leetcode_1080_根到叶路径上的不足节点 {
    /**
     * 解1 自己写的
     * @param root
     * @param limit
     * @return
     */
//    public TreeNode sufficientSubset(TreeNode root, int limit) {
//        if(root == null) return null;
//        boolean isLeaf = root.left == null && root.right == null;
//
//        root.left = sufficientSubset(root.left, limit - root.val);
//        root.right = sufficientSubset(root.right, limit - root.val);
//
//
//        //返回null有两种情况
//        // 1. 真叶子结点 ： 则值小于剩余的值
//        // 2. 假叶子结点 ： 子节点被删除后变成的叶子结点  这种情况下不需要管此节点值 都要给删除
//        if(root.left == null && root.right == null){
//            if(root.val < limit || !isLeaf){
//                return null;
//            }
//        }
//
//        return root;
//    }

    /**
     * 解2
     *
     * 利用全局变量 在层级之间回溯
     */
    int sum = 0;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root.val + sum < limit ? null : root;
        sum += root.val;
        TreeNode left = sufficientSubset(root.left, limit);
        TreeNode right = sufficientSubset(root.right, limit);
        sum -= root.val;
        if (left == null) root.left = null;
        if (right == null) root.right = null;
        return left == null && right == null ? null : root;
    }
}
