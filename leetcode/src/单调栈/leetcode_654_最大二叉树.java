package 单调栈;

import 二叉树.TreeNode;

import java.util.Stack;

/**
 * @ClassName leetcode_654_最大二叉树
 * @Author zxf
 * @Date 2023/12/20 17:00
 * @Questinon Describrition
 *
 * 几百5.02%
 **/
public class leetcode_654_最大二叉树 {
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
