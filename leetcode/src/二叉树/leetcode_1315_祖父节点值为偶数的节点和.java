package 二叉树;

/**
 * @ClassName leetcode_1315_祖父节点值为偶数的节点和
 * @Author zxf
 * @Date 2024/1/3 16:59
 * @Questinon Describrition
 **/
public class leetcode_1315_祖父节点值为偶数的节点和 {
    int res = 0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) return 0;
        dfs(root,-1,-1);
        return res;
    }

    /**
     *
     * @param node      当前节点
     * @param farther   父节点给的信息 如果父节点是偶数 则为1 否则为-1
     * @param grand     祖父节点给的信息 如果祖父节点是偶数则为1 否则为-1
     */
    private void dfs(TreeNode node ,int farther,int grand){
        if(node == null) return;

        if(grand == 1){
            res += node.val;
        }

        //奇数
        if((node.val & 1) == 1){
            dfs(node.left,-1,farther);
            dfs(node.right,-1,farther);
        }else{
            dfs(node.left,1,farther);
            dfs(node.right,1,farther);
        }
    }
}
