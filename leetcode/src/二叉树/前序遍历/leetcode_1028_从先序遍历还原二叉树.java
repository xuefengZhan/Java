package 二叉树.前序遍历;

import 二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName leetcode_1028_从先序遍历还原二叉树
 * @Author zxf
 * @Date 2023/12/21 9:39
 * @Questinon Describrition
 **/
public class leetcode_1028_从先序遍历还原二叉树 {

    public TreeNode recoverFromPreorder(String traversal) {
        ArrayList<int[]> arr = new ArrayList<>();
        char[] chars = traversal.toCharArray();
        int len = chars.length;
        System.out.println(chars);
        int start = 0;
        int end = 0;
        int num = 0; // - 的个数

        while(start < len){
            if(chars[start] == '-'){
                start++;
                num++;
            }else{
                end = start;
                while(end < len && chars[end] != '-'){
                    end++;
                }
                //end == len  或者 = '-'
                int cur = Integer.parseInt(traversal.substring(start,end));
                arr.add(new int[]{num,cur});
                num = 0;
                start = end;
            }
        }

        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }

        return dfs(arr,0,arr.size()-1,0);

    }


    /**
     *
     * @param arr
     * @param start   当前子树的根节点所在位置
     * @param end     当前子树最后一个节点所在位置
     * @param level   当前节点的层级
     * @return
     */
    private TreeNode dfs(ArrayList<int[]> arr ,int start,int end,int level){
        if(start  > end){
            return null;
        }

        //创建当前节点
        TreeNode root = new TreeNode(arr.get(start)[1]);

        int leftStart = -1;
        int rightStart = -1;

        //当前子树下 最多只会有两个子节点
        for (int i = start + 1; i <= end; i++) {
            //如果是下一层的
            if(arr.get(i)[0] == level + 1){
                if(leftStart == -1){
                    leftStart = i;
                }else{
                    rightStart = i;
                }
            }
        }

        if(leftStart == -1){
            //左边都没
            return root;
        }else {
            if(rightStart == -1){//没有右边
                root.left = dfs(arr,leftStart,end ,level+1);
            }else{
                root.left = dfs(arr,leftStart,rightStart-1,level+1);
                root.right = dfs(arr,rightStart,end,level+1);
            }
            return root;
        }
    }


    public static void main(String[] args) {
        leetcode_1028_从先序遍历还原二叉树 v = new leetcode_1028_从先序遍历还原二叉树();

        String s = "1-2--3---4-5--6---7";

        TreeNode res = v.recoverFromPreorder(s);


    }
}
