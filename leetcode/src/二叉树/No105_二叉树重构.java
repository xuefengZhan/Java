package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;

public class No105_二叉树重构 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 1) return new TreeNode(inorder[0]);

        TreeNode root = new TreeNode(preorder[0]);
        int mid = findIndex(inorder,preorder[0]);
        int[] prev = ArrayCopy(preorder,1,mid);

        int[] aft = ArrayCopy(preorder,mid+1,preorder.length-1);
        int[] left = ArrayCopy(inorder,0,mid-1);
        int[] right = ArrayCopy(inorder,mid+1,inorder.length-1);
        System.out.println(Arrays.toString(prev));
        System.out.println(Arrays.toString( aft));
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        root.left = buildTree(prev,left);
        root.right = buildTree(aft,right);

        return root;
    }





    private int findIndex(int[] inorder,int val){
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;
    }


    private int[] ArrayCopy(int[] arr,int start,int end){
        int[] newArr = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            newArr[i-start] = arr[start];
        }
        return newArr;
    }

    public static void main(String[] args) {
        No105_二叉树重构 v = new No105_二叉树重构();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = v.buildTree(preorder, inorder);

        System.out.println(treeNode);
    }
}
