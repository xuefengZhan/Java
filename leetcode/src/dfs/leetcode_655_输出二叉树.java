package dfs;

import 二叉树.TreeNode;

import java.util.*;

/**
 * @ClassName leetcode_655_输出二叉树
 * @Author zxf
 * @Date 2023/10/8 15:38
 * @Questinon Describrition
 **/
public class leetcode_655_输出二叉树 {
    int height ;
    List<List<String>> res;
    private int getHeight(TreeNode node,int height){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return height;
        height++;
        return Math.max(getHeight(node.left,height) , getHeight(node.right,height));
    }


    public List<List<String>> printTree(TreeNode root) {
        height = getHeight(root,0);
        int col = (1 << (height + 1)) - 1; // (int) Math.pow(2,height+1) - 1;

        res = new ArrayList<List<String>>(height);
        for (int i = 0; i <= height ; i++) {
            ArrayList<String> line = new ArrayList<>(col);
            for (int j = 0; j < col; j++) {
                line.add("");
            }
            res.add(line);
        }

        dfs(root,0,(col - 1) / 2);
        return res;
    }


    private void dfs(TreeNode node,int height,int index){
        if(height > this.height  || node == null ) return;

        List<String> line = res.get(height);
        line.set(index,""+node.val);


        dfs(node.left,height+1, index - (int) Math.pow(2, this.height - height - 1));
        dfs(node.right,height+1, index + (int) Math.pow(2, this.height - height - 1));

    }
}
