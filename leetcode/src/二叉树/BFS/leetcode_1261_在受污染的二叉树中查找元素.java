package 二叉树.BFS;

import 二叉树.TreeNode;

/**
 * @ClassName leetcode_1261_在受污染的二叉树中查找元素
 * @Author zxf
 * @Date 2024/1/2 11:39
 * @Questinon Describrition
 **/
public class leetcode_1261_在受污染的二叉树中查找元素 {

}

class FindElements {

//    int[] arr = new int[10000000];
//    public FindElements(TreeNode root) {
//        dfs(root,0);
//    }
//
//
//    private void dfs(TreeNode node,int val){
//        if(node == null) return;
//
//        node.val = val;
//        arr[val] = 1;
//
//        dfs(node.left,val*2+1);
//        dfs(node.right,val*2+2);
//    }
//
//
//    public boolean find(int target) {
//        return arr[target] == 1;
//    }


    /**
     *  优化 使用bit位来记录
     */

    int[] arr = new int[40000];   //31250个int 对应 31250 * 32个bit位置
        public FindElements(TreeNode root) {
            dfs(root,0);
        }


        private void dfs(TreeNode node,int val){
            if(node == null) return;

            node.val = val;

            //todo 2. 存到集合中 便于查找
            int index = val / 32; //第val个bit位要置1 每份32bit
            int num = val % 32;   //32个中间的第num个要置为1
            arr[index] += 1 << num;

            dfs(node.left,val*2+1);
            dfs(node.right,val*2+2);
        }


        public boolean find(int target) {
            int index = target / 32;
            int num = target % 32;
            int tmp = 1 << num;
            return ( arr[index] &  tmp) == tmp;
        }
}

