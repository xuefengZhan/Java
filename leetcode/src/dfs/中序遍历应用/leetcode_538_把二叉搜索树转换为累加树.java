package dfs.中序遍历应用;

import 二叉树.TreeNode;

/**
 * @ClassName leetcode_538_把二叉搜索树转换为累加树
 * @Author zxf
 * @Date 2023/10/7 9:26
 * @Questinon Describrition
 *
 * 0ms   中序遍历应用
 **/
public class leetcode_538_把二叉搜索树转换为累加树 {

    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
