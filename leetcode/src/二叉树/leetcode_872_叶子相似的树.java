package 二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName leetcode_872_叶子相似的树
 * @Author zxf
 * @Date 2023/1/11 19:41
 **/
public class leetcode_872_叶子相似的树 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> res1 = new ArrayList();
        List<Integer> res2 = new ArrayList();

        dfs(root1,res1);
        dfs(root2,res2);

        if(res1.size() != res2.size()) return false;

        for(int i = 0;i<res1.size();i++){
            if(res1.get(i) != res2.get(i)) return false;
        }

        return true;


    }


    private void dfs(TreeNode root,List<Integer> leaves){
        if(root == null) return;
        if(root.left == null && root.right == null){
            leaves.add(root.val);
            return;
        }

        dfs(root.left,leaves);
        dfs(root.right,leaves);


    }
}
