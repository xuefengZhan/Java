package dp.树形DP;

import 二叉树.TreeNode;

/**
 * @ClassName leetcode_968_监控二叉树
 * @Author zxf
 * @Date 2023/12/6 17:29
 * @Questinon Describrition
 **/
public class leetcode_968_监控二叉树 {
    public int minCameraCover(TreeNode root) {
        int[] dfs = dfs(root);

        return Math.min(dfs[0],dfs[2]);
    }


    private int[] dfs(TreeNode node){
        if(node == null) return new int[]{0,0,0};

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);


        int blue = Math.min(Math.min(l[0],l[2]),l[1]) + Math.min(Math.min(r[0],r[2]),r[1]) + 1;

        int yellow =  Math.min(l[0],l[2]) + Math.min(r[0],r[2]) ;


        int red = Math.min( Math.min(l[0],r[2]), Math.min(r[2],r[0]) ) + Math.min(l[0],r[0]);


        return new int[]{blue,yellow,red};

    }
}
