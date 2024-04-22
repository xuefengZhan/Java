package 二叉树;

/**
 * @ClassName leetcode_2265_统计值等于子树平均值的节点数
 * @Author zxf
 * @Date 2024/1/19 13:46
 * @Questinon Describrition
 **/
public class leetcode_2265_统计值等于子树平均值的节点数 {
    int res = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode node){
        if(node == null) return new int[]{0,0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int num = left[0]+right[0]+1;
        int sum = left[1]+right[1]+node.val;

        if(sum / num == node.val) res++;
        return new int[]{num,sum};
    }

}
