package 二叉树;

/**
 * @ClassName leetcode_998_最大二叉树Ⅱ
 * @Author zxf
 * @Date 2023/12/28 10:33
 * @Questinon Describrition
 **/
public class leetcode_998_最大二叉树Ⅱ {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {

        TreeNode parent = null;
        TreeNode cur = root;

        if(cur == null){
            return new TreeNode(val);
        }

        while(cur != null){
            //如果root值比当前大，那么当前节点只能在root节点的右子树中（当前节点在序列的右边）
            if(val < cur.val){
                parent = cur;
                cur = cur.right;
            }else{
                //如果root值比当前小，则root变为当前节点的左子节点，当前节点替换root节点
                TreeNode newRoot = new TreeNode(val);
                if(parent != null){
                    parent.right = newRoot;
                }else{
                    root = newRoot;
                }
                newRoot.left = cur;
                return root;
            }
        }
        //cur == null 说明最小
        parent.right = new TreeNode(val);
        return root;
    }
}
