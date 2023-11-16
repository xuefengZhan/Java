package 二叉树;

import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName leetcode_297_二叉树的序列化和反序列化
 * @Author zxf
 * @Date 2023/11/3 18:14
 * @Questinon Describrition
 *
 * 本题和971题有相似之处
 **/
public class leetcode_297_二叉树的序列化和反序列化 {

    int index = 0;
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void dfs(TreeNode node){
        if(node == null){
            sb.append("None,");
            return;
        }


        sb.append(node.val).append(",");
        dfs(node.left);
        dfs(node.right);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        System.out.println(Arrays.toString(nodes));
        return dfs2(nodes);
    }

    private TreeNode dfs2(String[] nodes){


//        if(nodes[index].equals("None")){
//            return null;
//        }
//
//        int rootval = Integer.parseInt(nodes[index]);
//        index++;
//
//        TreeNode left = dfs2(nodes);
//        TreeNode right = dfs2(nodes);
//
//        return new TreeNode(rootval,left,right);

        String nodeval = nodes[index++];

        if("None".equals(nodeval)){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodeval));

        node.left = dfs2(nodes);
        node.right = dfs2(nodes);

        return node;


    }


//    private TreeNode dfs2(String[] nodes,int index){
//
//
//        if(nodes[index].equals("None")){
//            index = index + 1;
//            return null;
//        }
//
//        int rootval = Integer.parseInt(nodes[index++]);
//
//
//        TreeNode left = dfs2(nodes,index);
//        TreeNode right = dfs2(nodes,index);
//
//        return new TreeNode(rootval,left,right);
//    }

    public static void main(String[] args) {
        leetcode_297_二叉树的序列化和反序列化 v = new leetcode_297_二叉树的序列化和反序列化();

    }
}
