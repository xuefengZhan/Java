package 二叉树;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName leetcode_988_从叶子结点开始最小字符串
 * @Author zxf
 * @Date 2023/11/17 10:09
 * @Questinon Describrition
 *
 * 这题的特点是需要遍历全部字符串 取最小的
 **/
public class leetcode_988_从叶子结点开始最小字符串 {

    String res = "~"; //很大
    public String smallestFromLeaf(TreeNode root) {
        if(root == null) return "";
        dfs(root,new StringBuilder());
        return res;
    }



    private void dfs(TreeNode node,StringBuilder sb){
        if(node == null) return;

        char cur = (char) ('a' + node.val);

        sb.append(cur);

        //如果是叶子结点
        if(node.left == null && node.right == null){
            StringBuilder s1 = new StringBuilder(sb.toString());
            String s = s1.reverse().toString();
            res = s.compareTo(res) > 0 ? res : s;
        }

        dfs(node.left,sb);
        dfs(node.right,sb);

        sb.deleteCharAt(sb.length() - 1);
    }
}
