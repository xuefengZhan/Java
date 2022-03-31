package 回溯;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No113_路径总和II {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        List<TreeNode> chooses = new ArrayList<TreeNode>();
        chooses.add(root);
        dfs(chooses,new ArrayList<Integer>(),0,targetSum);
        return res;
    }

    /**
     *
     * @param chooses 当前可选项
     * @param path    当前路径
     * @param sum     当前路径和
     * @param targetSum   目标路径和
     */
    private void dfs( List<TreeNode> chooses, ArrayList<Integer> path, int sum, int targetSum){

        if(chooses.isEmpty()){
            if(sum != targetSum){
                return;
            }else{
                res.add(new ArrayList<>(path));
                return;
            }
        }


        //todo 2.给当前做选择
        for (TreeNode node : chooses) {

            //2.做当下选择
            path.add(node.val);
            List<TreeNode> sonChooses = new ArrayList<TreeNode>();
            if (node.left != null) {
                sonChooses.add(node.left);
            }
            if (node.right != null) {
                sonChooses.add(node.right);
            }
            //3.下一层
            dfs(sonChooses, path, sum + node.val, targetSum);
            //4.回溯当前层
            path.remove(path.size() - 1);
        }

    }
}
