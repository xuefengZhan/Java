package dfs;

import 二叉树.TreeNode;

public class lt669_修剪二叉搜索树 {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        //1.边界条件
        if(root == null) return null;

        if(root.val < low){
            root = root.right;
            return trimBST(root,low,high);
        }

        if(root.val > high){
            root = root.left;
            return trimBST(root,low,high);
        }

        if(root.val == low){
            root.left = null;
            root.right = trimBST(root.right,low,high);
            return root;
        }

        if(root.val == high){
            root.right = null;
            root.left = trimBST(root.left,low,high);
            return root;
        }

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }

}
