package 二叉树;

public class No606_根据二叉树创建字符串 {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        travel(root,sb);
        return sb.toString();
    }

    public void travel(TreeNode root,StringBuilder sb){
        if(root == null){
            return;
        }

        sb.append(root.val);

        if(root.right != null){

            sb.append("(");
            travel(root.left,sb);
            sb.append(")");

            sb.append("(");
            travel(root.right,sb);
            sb.append(")");
        }else if(root.left != null){ //right == null
            sb.append("(");
            travel(root.left,sb);
            sb.append(")");
        }
    }

    //执行用时：
    //100.00%

    //内存消耗：
    //10.10%

}
