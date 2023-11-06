package 二叉树;

/**
 * @ClassName leetcode_106_从中序和后序遍历序列构造二叉树
 * @Author zxf
 * @Date 2023/11/3 11:07
 * @Questinon Describrition
 **/
public class leetcode_106_中序和后序重构二叉树 {
    int[] map1 = new int[6001];
    int[] map2 = new int[6001];

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map1[inorder[i] + 3000] = i;
        }

        for (int i = 0; i < postorder.length; i++) {
            map2[postorder[i] + 3000] = i;
        }

        return  dfs(inorder,0,inorder.length-1,postorder,0,postorder.length-1);

    }


    private TreeNode dfs(int[] inorder, int i_left,int i_right,int[] postorder,int p_left,int p_right) {

        if(i_left > i_right){
            return null;
        }

        if(i_left == i_right){
            return new TreeNode(inorder[i_left],null,null);
        }

        //根节点在后序遍历的最后一个
        int root = postorder[p_right];
        //获取根节点在中序遍历的位置
        int rootIndex = map1[root + 3000];

        //左子树节点数
        int leftLen = rootIndex - i_left;


        TreeNode left = dfs(inorder,i_left,rootIndex-1,postorder,p_left,p_left+leftLen-1);
        TreeNode right = dfs(inorder,rootIndex+1,i_right,postorder,p_left+leftLen,p_right-1);
        return new TreeNode(root,left,right);
    }
}
