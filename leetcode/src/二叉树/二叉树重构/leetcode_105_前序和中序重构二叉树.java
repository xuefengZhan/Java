package 二叉树.二叉树重构;

import 二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName leetcode_105_前序和中序重构二叉树
 * @Author zxf
 * @Date 2023/2/3 9:19
 **/
public class leetcode_105_前序和中序重构二叉树 {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0;i< inorder.length;i++){
            map.put(preorder[i],i);
        }

        return dfs(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    private TreeNode dfs(int[] preorder,int preLeft,int preRight,int[] inorder,int inLeft,int inRight){
        if(preRight < preLeft) return null;

        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        //区分左右子树
        Integer rootIndex = map.get(rootVal);
        //中序遍历中 左子树 [inLeft,rootIndex-1] , 右子树[rootIndex+1,inRight]
        //前序遍历中 左子树 [preLeft+1,rootIndex -1 - inLeft + preLeft + 1] ,右子树 [rootIndex -1 - inLeft + preLeft + 1 + 1,preRight]

        root.left = dfs(preorder,preLeft+1,rootIndex  - inLeft + preLeft ,inorder,inLeft,rootIndex-1);
        root.right = dfs(preorder,rootIndex  - inLeft + preLeft + 1,preRight,inorder,rootIndex+1,inRight);

        return root;
    }





}
