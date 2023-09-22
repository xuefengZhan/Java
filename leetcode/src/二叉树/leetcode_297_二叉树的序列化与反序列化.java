package 二叉树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @ClassName leetcode_297_二叉树的序列化与反序列化
 * @Author zxf
 * @Date 2023/2/10 9:06
 **/
public class leetcode_297_二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {

        TreeNode cur = root;
        StringBuilder sb = new StringBuilder();

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                //访问当前节点
                stack.push(cur);
                sb.append(cur.val).append(",");
                //迭代
                cur = cur.left;
            }else{
                //访问当前节点
                sb.append("null").append(",");
                //迭代
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    TreeNode root;
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        System.out.println(Arrays.toString(split));
        dfs(split,0,null);
        return root;
    }

    private TreeNode dfs(String[] data,int index,TreeNode cur){
        if(index == data.length || Objects.equals(data[index], "null")){
            return null;
        }


        TreeNode currentNode = new TreeNode(Integer.parseInt(data[index]));
        if(index == 0){
            root = currentNode;
        }
        cur = currentNode;
        dfs(data,++index,cur.left);
        dfs(data,++index,cur.right);
        return root;
    }


    public static void main(String[] args) {
        leetcode_297_二叉树的序列化与反序列化 v = new leetcode_297_二叉树的序列化与反序列化();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        root.right = n3;
        TreeNode n4 = new TreeNode(4);
        n3.left = n4;
        TreeNode n5 = new TreeNode(5);
        n3.right = n5;

        String serialize = v.serialize(root);
        System.out.println(serialize);

        String data  = "1,2,null,null,3,4,null,null,5,null,";
        TreeNode deserialize = v.deserialize(data);
        System.out.println(v.serialize(deserialize));
    }
}
