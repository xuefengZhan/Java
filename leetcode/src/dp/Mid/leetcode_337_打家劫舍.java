package dp.Mid;

import 二叉树.TreeNode;

import java.util.HashMap;

/**
 * @ClassName leetcode_337_打家劫舍
 * @Author zxf
 * @Date 2023/9/12 10:43
 * @Questinon Describrition
 **/
public class leetcode_337_打家劫舍 {


//    HashMap<TreeNode,Integer> map = new HashMap<>();
//    public int rob(TreeNode root) {
//
//        if(root == null) return 0;
//
//        if(map.containsKey(root)){
//            return map.get(root);
//        }
//
//        //偷这家  不偷这家
//        int val = root.val;
//        int ll = 0;
//        int lr = 0;
//        int rl = 0;
//        int rr = 0;
//
//
//
//
//        if(root.left != null){
//            ll = rob(root.left.left);
//            lr = rob(root.left.right);
//        }
//
//        if(root.right != null){
//            rl = rob(root.right.left);
//            rr = rob(root.right.right);
//        }
//
//
//        int left = rob(root.left);
//        int right = rob(root.right);
//
//        int res = Math.max(ll+lr+rl+rr+val,left+right);
//
//        map.put(root,res);
//        return res;
//    }



    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }


    private int[] dfs(TreeNode node){

        if (node == null) {
            return new int[]{0, 0};
        }

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        //0 偷这家 1不偷这家

        int a = node.val + l[1] + r[1];
        int b =  Math.max(l[0], l[1]) + Math.max(r[0], r[1]);

        return new int[]{a,b};

    }

}
