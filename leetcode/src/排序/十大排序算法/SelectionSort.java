package 排序.十大排序算法;

/**
 * @ClassName SelectionSort
 * @Author zxf
 * @Date 2023/6/20 16:53
 **/
public class SelectionSort {
    int[] arr;

    private void swap(int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    protected void sort() {
      for(int end = arr.length - 1;end>0;end--){
          int maxIndex =  end;
          for(int i = 0;i<end;i++){
              if(arr[i] > arr[maxIndex]){
                  maxIndex = i;
              }
          }
          swap(maxIndex,end);
      }
    }
}
