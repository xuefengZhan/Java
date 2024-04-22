package 二叉树.BST;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName leetcode_1382_将二叉搜索树变平衡
 * @Author zxf
 * @Date 2024/1/9 9:19
 * @Questinon Describrition
 **/
public class leetcode_1382_将二叉搜索树变平衡 {
    ArrayList<Integer> arr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        //中序遍历 放进arr
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;


        while(true){
            if(cur != null){
                //第一次访问当前节点将其入栈
                stack.push(cur);
                cur = cur.left;
            }else{
                //cur == null 第二次访问栈顶节点  出栈后再也访问不到了
                if(!stack.isEmpty()){
                    TreeNode pop = stack.pop();
                    arr.add(pop.val);
                    cur = pop.right;
                }else{
                    break;
                }
            }
        }


        return dfs(arr,0,arr.size()-1);
    }

    private TreeNode dfs(ArrayList<Integer> arr,int start,int end){
        if(start == end){
            return new TreeNode(arr.get(start));
        }

        int mid = (end - start) / 2 + start;

        TreeNode root = new TreeNode(arr.get(mid));
        TreeNode left = dfs(arr,start,mid-1);
        TreeNode right = dfs(arr,mid+1,end);

        root.left = left;
        root.right = right;

        return root;
    }


}
