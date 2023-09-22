package dfs;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lt652_重复的子树 {
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        dfs(root.left,root.right);

        return res;
    }

    private boolean isSame(TreeNode node1,TreeNode node2){
        if(node1 == null && node2 == null) return true;

        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;

        boolean flag  = isSame(node1.left,node2.left) && isSame(node1.right,node2.right);

        if(flag) res.add(node1);

        return flag;
    }

    //找node节点 右子树中 有没有结构 和左子树相同的结构
    private void dfs(TreeNode node1,TreeNode node2){
        boolean flag = isSame(node1,node2);

        if(flag) return;

        dfs(node1,node2.left);

        dfs(node1,node2.right);

        dfs(node1.left,node2);
        dfs(node1.right,node2);


    }
}
