package 二叉树.前序遍历;

import 二叉树.TreeNode;

import java.sql.SQLOutput;

/**
 * @ClassName leetcode_1008_前序遍历构造二叉搜索树
 * @Author zxf
 * @Date 2023/12/26 11:54
 * @Questinon Describrition
 **/
public class leetcode_1008_前序遍历构造二叉搜索树 {
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder,0,preorder.length - 1);
    }
    
    
    private TreeNode dfs(int[] preorder,int start,int end){
        if(start > end || preorder == null || preorder.length == 0 ) return null;

        TreeNode root = new TreeNode(preorder[start]);
        if(start == end){
            return root;
        }
        
        int leftEnd = -1;
        for (int i = start+1; i <= end; i++) {
            if(preorder[i] < preorder[start]){
                leftEnd = i;
            }else{
                break;
            }
        }

        int rightStart = start + 1;//没有左子树
        if(leftEnd != -1){
            //有左子树
            rightStart = leftEnd + 1;
        }


        System.out.println("currentNode " + preorder[start] );
        System.out.println("leftRange " + start + 1 + " and " + leftEnd);
        System.out.println("RightRange " + leftEnd + 1 + " and " + end);


        root.left = dfs(preorder,start+1,leftEnd );
        root.right = dfs(preorder,rightStart,end);

        return root;
    }
}
