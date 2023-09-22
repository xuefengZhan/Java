package 二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_113_路径总和2
 * @Author zxf
 * @Date 2023/2/6 9:10
 **/
public class leetcode_113_路径总和2 {

    /**
     *  解法1 ： 当前节点未处理
     */
//    List<List<Integer>> res = new ArrayList<>();
//
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        dfs(root,targetSum,new ArrayList<Integer>());
//        return res;
//    }
//
//
//    private void dfs(TreeNode node,int targetSum,ArrayList<Integer> path){
//        if(node == null) return;
//
//
//
//        path.add(node.val);
//        if(node.left == null && node.right == null && targetSum == node.val){
//            res.add(new ArrayList<>(path));
//        }
//
//        dfs(node.left,targetSum - node.val,path);
//        dfs(node.right,targetSum - node.val,path);
//        //当前处理哪个节点  回退哪个节点
//        path.remove(path.size() - 1);
//    }


    /**
     *  解法2 当前节点已处理 ： 对比解法1
     */
//    List<List<Integer>>  res = new ArrayList();
//
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        if(root == null) return res;
//        ArrayList<Integer> path = new ArrayList<Integer>();
//        path.add(root.val);
//        dfs(root,path,targetSum - root.val);
//        return res;
//    }
//
//
//    //node:可选项
//    //路径
//    private void dfs(TreeNode node,List<Integer> path,int targetLeft){
//        if(node == null) return;
//
//        if(targetLeft == 0 && node.left == null && node.right == null){
//            res.add(new ArrayList(path));
//            return;
//        }
//
//        if(node.left != null){
//            path.add(node.left.val);
//            dfs(node.left,path,targetLeft - node.left.val);
//            path.remove(path.size() - 1);
//        }
//        if(node.right != null){
//            path.add(node.right.val);
//            dfs(node.right,path,targetLeft - node.right.val);
//            path.remove(path.size() - 1);
//        }
//    }

    /**
     *  解法3 ： 也是当前节点已处理的做法
     */
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
