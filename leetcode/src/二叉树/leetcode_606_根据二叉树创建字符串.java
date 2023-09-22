package 二叉树;

public class leetcode_606_根据二叉树创建字符串 {
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.toString();

    }

    private void dfs(TreeNode root){
        if(root == null) return ;

        sb.append(root.val);


        if(root.left == null && root.right == null){
            return;
        }
        sb.append("(");
        dfs(root.left);
        sb.append(")");

        if(root.right != null){
            sb.append("(");
            dfs(root.right);
            sb.append(")");
        }
    }








    //执行用时：
    //100.00%

    //内存消耗：
    //10.10%

}
