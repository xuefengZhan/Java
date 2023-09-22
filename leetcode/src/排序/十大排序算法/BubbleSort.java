package 排序.十大排序算法;

/**
 * @ClassName BubbleSort
 * @Author zxf
 * @Date 2023/6/20 16:35
 *
 *
 * 冒泡排序
 **/
public class BubbleSort{
    int[] arr;

    protected void sort() {
        for(int end = arr.length - 1;end > 0 ; end --){
            for(int i = 0;i<end;i++){
                if(arr[i] > arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
    }
}

