package 二叉树;

/**
 * @Date 2023/11/9 0:37
 * @Author 詹学丰
 * @Name leetcode_654_最大二叉树
 * @QUESTION DESCRIPTION
 * @TAG
 * @RESULT
 **/

public class leetcode_654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = new TreeNode(-1);

        dfs(nums,0,root);

        return root;
    }


    private void dfs(int[] nums,int index,TreeNode parent){
        //当前节点
        TreeNode node = new TreeNode(nums[index]);
        if(parent.val > nums[index]){
            parent.right = node;
            dfs(nums,index++,node);
        }else{

        }


    }
}
