package dfs;

import 二叉树.TreeNode;

/**
 * @ClassName leetcode_623_在二叉树中增加一行
 * @Author zxf
 * @Date 2023/10/7 11:13
 * @Questinon Describrition
 **/
public class leetcode_623_在二叉树中增加一行 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            return new TreeNode(val,root,null);
        }
        dfs(root,val,2,depth);
        return root;
    }


    public void dfs(TreeNode parent,int val,int depth,int level){


        if(parent == null) return;



        //到达目标层
        if(depth == level){
            TreeNode leftNode = parent.left;
            TreeNode rightNode = parent.right;


            TreeNode LNode = new TreeNode(val, leftNode, null);
            TreeNode RNode = new TreeNode(val, null, rightNode);

            parent.left = LNode;
            parent.right = RNode;

            return;
        }

        dfs(parent.left,val, depth + 1,level);
        dfs(parent.right,val,depth+1,level);
    }
}
