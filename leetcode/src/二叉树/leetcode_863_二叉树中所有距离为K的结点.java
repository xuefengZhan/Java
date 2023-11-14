package 二叉树;

import java.util.*;

/**
 * @ClassName leetcode_863_二叉树中所有距离为K的结点
 * @Author zxf
 * @Date 2023/11/14 9:23
 * @Questinon Describrition
 **/
public class leetcode_863_二叉树中所有距离为K的结点 {

    Map<Integer,TreeNode> map = new HashMap();
    List<Integer> res = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        if(root == null) return null;

        getParent(root,null);
        for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            TreeNode parent = entry.getValue();
            Integer value = parent == null ? null : parent.val;
            System.out.println(entry.getKey() + " -> "  + value);
        }

        //dfs(target,k);
        dfs(target,null,k);
        return res;
    }

    // hashset 用于记录已经访问过的节点 防止重复访问
//    HashSet<Integer> visited = new HashSet();
//    private void dfs(TreeNode node,int k ){
//        if(node == null || visited.contains(node.val)){
//            return ;
//        }
//
//        visited.add(node.val);
//
//        if(k == 0){
//            res.add(node.val);
//            return;
//        }
//
//        dfs(node.left,k-1);
//        dfs(node.right,k-1);
//        dfs(map.get(node.val),k-1);
//    }


    //记录当前节点从哪个节点过来的，这样就不会下次走回头路了
    private void dfs(TreeNode node,TreeNode from,int k){
        if(node == null) return;

        if(k == 0){
            res.add(node.val);
            return ;
        }

        if(node.left != from){
            dfs(node.left,node,k-1);
        }

        if(node.right != from){
            dfs(node.right,node,k-1);
        }

        if(map.get(node.val) != from){
            dfs(map.get(node.val),node,k-1);
        }
    }

    private void getParent(TreeNode node,TreeNode parent){
        if(node == null) return;

        map.put(node.val,parent);

        getParent(node.left,node);
        getParent(node.right,node);
    }
}
