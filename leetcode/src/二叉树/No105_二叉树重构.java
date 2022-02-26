package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *      https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/submissions/
        5.76%
 */
public class No105_二叉树重构 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        if(inorder.length == 1) return new TreeNode(inorder[0]);

        int rootVal = preorder[0];
        int index = indexOf(inorder, rootVal);

        int[] leftInorder = copy(inorder,0,index-1);
        int[] rightInorder = copy(inorder,index + 1,inorder.length - 1);

        int[] leftPreorder = copy(preorder,1,index);
        int[] rightPreorder = copy(preorder,index+1,preorder.length-1);

        TreeNode root = new TreeNode(rootVal);

        TreeNode leftRoot = buildTree(leftPreorder,leftInorder);
        TreeNode rightRoot = buildTree(rightPreorder,rightInorder);

        root.left = leftRoot;
        root.right = rightRoot;

        return root;
    }

    private int indexOf(int[] arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target) return i;
        }
        return -1;
    }


    private int[] copy(int[] arr,int start,int end){

        int[] tmp = new int[end - start + 1];
        int tmpi = 0;
        for (int i = start; i <=  end; i++) {
            tmp[tmpi] = arr[i];
            tmpi++;
        }
        return tmp;
    }








    public static void main(String[] args) {
        No105_二叉树重构 v = new No105_二叉树重构();

    }
}
