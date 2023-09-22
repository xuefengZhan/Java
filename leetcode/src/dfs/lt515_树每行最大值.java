package dfs;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lt515_树每行最大值 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root,0);
        return res;
    }


    private void dfs(TreeNode root,int height){
        if(root == null) return;

        //第一次访问该深度
        if(height == res.size()){
            res.add(root.val);
            //第n次访问该深度
        }else if(res.get(height) >= root.val){
            dfs(root.left,height + 1);
            dfs(root.right,height +1);
        }else{
            res.set(height,root.val);
            dfs(root.left,height + 1);
            dfs(root.right,height +1);
        }
    }
}
