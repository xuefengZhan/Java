package 数组;

import java.util.Arrays;

/**
 * 给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
 *
 * 1.保证 A 数组有足够的空间存放 B 数组的元素， A 和 B 中初始的元素数目分别为 m 和 n，A的数组空间大小为 m+n
 * 2.不要返回合并的数组，将数组 B 的数据合并到 A 里面就好了
 * 3. A 数组在[0,m-1]的范围也是有序的
 */
public class NC22_合并两个有序的数组 {
    public void merge(int A[], int m, int B[], int n) {


        int[] tmp = new int[m];
        for(int i = 0;i<m;i++){
            tmp[i] = A[i];
        }

        int left = 0;
        int right = 0;

        for(int i = 0;i < m+n ; i++ ){
            if((left < m && right < n && tmp[left] <= B[right]) || right >= n){
                A[i] = tmp[left];
                left++;
            } else{
                A[i] = B[right];
                right++;
            }
        }
    }

    /**
     * 超过98.68% 用Java提交的代码
     */

    public static void main(String[] args) {
        NC22_合并两个有序的数组 v = new NC22_合并两个有序的数组();
        int[] A = {4,5,6,0,0,0};
        int[] B = {1,2,3};

        v.merge(A,3,B,3);
        System.out.println(Arrays.toString(A));
    }
}
