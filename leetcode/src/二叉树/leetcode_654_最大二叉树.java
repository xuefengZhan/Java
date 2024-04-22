package 二叉树;

import java.util.Stack;

/**
 * @Date 2023/11/9 0:37
 * @Author 詹学丰
 * @Name leetcode_654_最大二叉树
 * @QUESTION DESCRIPTION
 * @TAG
 * @RESULT
 **/

public class leetcode_654_最大二叉树 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            Stack<TreeNode> stack = new Stack();
            TreeNode root = null;
            TreeNode curNode = null;


            for (int num : nums) {
                curNode = new TreeNode(num);
                if(stack.isEmpty()){
                    stack.push(curNode);
                    root = curNode;
                }else{
                    if(num < stack.peek().val){
                        stack.peek().right = curNode;
                        stack.push(curNode);
                    }else{
                        //前面小于num的全部拿出来 并且最后一个要做left节点
                        TreeNode left = null;
                        while(!stack.isEmpty() && num > stack.peek().val){
                            left = stack.pop();
                        }
                        curNode.left = left;

                        if(!stack.isEmpty()){
                            stack.peek().right = curNode;
                        }else{
                            root = curNode;
                        }
                        stack.push(curNode);
                    }
                }
            }

            return  root;
        }
    }
}
