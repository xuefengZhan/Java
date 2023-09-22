package 二叉树;

/**
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 *
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * easy
 *
 *    ☆☆☆☆
 *
 *    递归过程中迭代目标值，不一定递归函数的返回值就要是目标值！
 */
public class leetcode_543_二叉树的直径 {

    //非叶子结点的直径： 左子树高度 + 1 + 1 + 右子树高度
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    //自底向上获取高度
    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left  = dfs(root.left) ;
        int right = dfs(root.right);

        res = Math.max(res,left + right);

        return Math.max(left,right)  + 1;
    }


}
