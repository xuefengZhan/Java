package 二叉树;

/**
 * @ClassName leetcode_979_在二叉树中分配硬币
 * @Author zxf
 * @Date 2023/11/16 18:17
 * @Questinon Describrition
 **/
public class leetcode_979_在二叉树中分配硬币 {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        if(root == null ) return 0;
        dfs(root);

        return res;
    }


    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] cur = new int[]{left[0] + right[0] + 1,left[1] + right[1] + root.val};


        res += Math.abs(left[0] - left[1]) + Math.abs(right[0] - right[1]);

        return cur;

    }
}
