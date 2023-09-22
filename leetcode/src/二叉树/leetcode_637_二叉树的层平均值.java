package 二叉树;

import java.util.*;

public class leetcode_637_二叉树的层平均值{
//    public List<Double> averageOfLevels(TreeNode root) {
//
//        if(root == null) return new ArrayList<>();
//
//        List<Double> res = new ArrayList<>();
//
//        Queue<TreeNode> que = new LinkedList<>();
//        que.offer(root);
//        int levelSize = 1;
//        int prevLevelSize = 1;
//        double sum = 0;
//
//        while(! que.isEmpty()){
//            TreeNode poll = que.poll();
//            sum += poll.val;
//
//            if(poll.left != null) que.offer(poll.left);
//            if(poll.right != null) que.offer(poll.right);
//
//            if(--levelSize == 0){
//
//                res.add((double) sum / prevLevelSize);
//                levelSize = que.size();
//                prevLevelSize = que.size();
//                sum = 0;
//            }
//        }
//        return res;
//    }

    //key 是层数  value是size
    HashMap<Integer,Integer> map1 = new HashMap();
    //key 是层数  value是sum
    HashMap<Integer,Double> map2 = new HashMap();

    List<Double> res = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return  res;
        dfs(root,1);

        int size = map1.size();

        for (int i = 1; i <= size; i++) {
            Integer levelSize = map1.get(i);
            Double sum = map2.get(i);

            res.add(sum/levelSize);
        }


        return res;
    }

    private void dfs(TreeNode node,int deepth){
        if(node == null)  return;

        Integer levelSize = map1.getOrDefault(deepth, 0);
        Double sum = map2.getOrDefault(deepth, 0.0);

        map1.put(deepth,levelSize++);
        map2.put(deepth,sum+node.val);

        dfs(node.left,deepth+1);
        dfs(node.right,deepth+1);
    }
}
