package 二叉树;

/**
 * @ClassName leetcode_1325_删除指定值的叶子节点
 * @Author zxf
 * @Date 2024/1/3 18:07
 * @Questinon Describrition
 **/
public class leetcode_1325_删除指定值的叶子节点 {

    TreeNode root ;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.root = root;
        dfs(root,null,0,target);
        return this.root;
    }


    /**
     *
     * @param node              当前节点
     * @param parent            父节点
     * @param leftOrRight       当前节点是父节点的左节点还是右节点  -1为左 1为右
     * @param target            待删除结点值
     */
    private void dfs(TreeNode node ,TreeNode parent, int leftOrRight ,int target){
        if(node == null) return;


        dfs(node.left,node,-1,target);
        dfs(node.right,node,1,target);

        if(node.left == null && node.right == null){
            if(node.val != target){
                return;
            }

            if(parent != null){
                if(leftOrRight == -1){
                    parent.left = null;
                }else if(leftOrRight == 1){
                    parent.right = null;
                }
            }else{
                //parent == null 只有根节点
                root = null;
            }
        }
    }
}
