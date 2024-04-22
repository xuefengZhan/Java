package 二叉树;

/**
 * @ClassName leetcode_1361_验证二叉树
 * @Author zxf
 * @Date 2024/1/5 11:28
 * @Questinon Describrition
 **/
public class leetcode_1361_验证二叉树 {
    int[] arr; //记录每个节点的入度
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        arr = new int[n];

        for (int i = 0; i < n; i++) {

            if(i == 0){
                if(arr[0] != 0) return false;
            }else{
                if(arr[i] != 1) return false;
            }

            int leftNode = leftChild[i];
            int rightNode = rightChild[i];

            if(leftNode != -1){
                arr[leftNode] ++;
            }
            if(rightNode != -1){
                arr[rightNode]++;
            }

        }
        return true;
    }
}
