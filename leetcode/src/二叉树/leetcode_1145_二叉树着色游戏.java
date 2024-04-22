package 二叉树;

import java.util.Arrays;

/**
 * @ClassName leetcode_1145_二叉树着色游戏
 * @Author zxf
 * @Date 2024/1/2 10:46
 * @Questinon Describrition
 **/
public class leetcode_1145_二叉树着色游戏 {
    //将二叉树从x节点分为3个部分   极端情况就是 红方占据三个部分之一的全部
    //arr[0] 表示x节点的父节点部分
    //arr[1] 表示x节点的左子树部分
    //arr[2] 表示x节点的右子树部分
    int[] arr = new int[3];
    TreeNode xNode = null;

    int splitX;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        splitX = x;

        //父节点部分
        arr[0] = dfs(root);
        Arrays.sort(arr);
        return arr[2] > (arr[0] + arr[1] + 1);
    }


    private int dfs(TreeNode root){

        if(root == null) return 0;

        if(root.val == splitX){

            xNode = root;

            arr[1] = dfs(root.left);
            arr[2] = dfs(root.right);

            return 0;
        }

        return dfs(root.left) + dfs(root.right) + 1;
    }
}
