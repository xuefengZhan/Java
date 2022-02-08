package 二叉树;

import 二叉树.TreeNode;

import java.util.ArrayList;

public class NC45_实现二叉树先序中序和后序遍历 {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        ArrayList<Integer> prev = new ArrayList();
        ArrayList<Integer> mid = new ArrayList();
        ArrayList<Integer> aft = new ArrayList();

        help(root,prev,mid,aft);

        int[] prevArr = new int[prev.size()];
        int[] midArr = new int[prev.size()];
        int[] aftArr = new int[prev.size()];
        for (int i = 0; i < prev.size(); i++) {
            prevArr[i] = prev.get(i);
            midArr[i] = mid.get(i);
            aftArr[i] =  aft.get(i);
        }

        int[][] res = new int[3][];

        res[0] = prevArr;
        res[1] = midArr;
        res[2] = aftArr;

        return res;

    }

    private void help(TreeNode root,ArrayList<Integer> prev,ArrayList<Integer> mid,ArrayList<Integer> aft){
        if(root == null) return;

        prev.add(root.val);

        help(root.left,prev,mid,aft);

        mid.add(root.val);

        help(root.right,prev,mid,aft);

        aft.add(root.val);

    }



}
