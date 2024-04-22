package 二叉树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName leetcode_1110_删点成林
 * @Author zxf
 * @Date 2023/12/22 14:15
 * @Questinon Describrition
 **/
public class leetcode_1110_删点成林 {
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }


        res.add(root);
        dfs(root,null,0,set);
        return res;

    }


    private void dfs(TreeNode node,TreeNode parent,int position,HashSet<Integer> set){
        if(set.isEmpty() || node == null){
            return;
        }


        TreeNode left = node.left;
        TreeNode right = node.right;


        System.out.println("currentNode == " + node.val);
        System.out.println("set" + set);
        System.out.println("leftNode == " + ( left == null ? null : left.val));
        System.out.println("rightNode == " + (right == null ? null : right.val));

        if(set.contains(node.val)){

            set.remove(node.val);

            //断开当前节点和子节点的关系
            node.left = null;
            node.right = null;

            //断开当前节点和父节点的关系
            if(parent == null){
                node = null;
            }else{
                if(position == 0){
                    parent.left = null;
                }else{
                    parent.right = null;
                }
            }

            if(left != null) res.add(left);
            if(right != null)  res.add(right);
        }

        dfs(left,node,0,set);
        dfs(right,node,1,set);
    }
}
