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
public class No543_二叉树的直径 {
    //直径 ：  叶子节点 直径为0
    //高度：   叶子节点高度为0
    //非叶子结点的直径： 左子树高度 + 1 + 1 + 右子树高度


    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null || (root.left == null && root.right == null)) return 0;

        getHeight(root);

        return res;
    }


    private int getHeight(TreeNode root){
        if(root == null ) return -1;
        if(root.left == null && root.right == null) return 0;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        res = Math.max(leftHeight + rightHeight + 2,res);


        return Math.max(leftHeight,rightHeight) + 1;
    }
}
