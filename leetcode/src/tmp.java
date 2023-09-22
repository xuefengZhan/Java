import java.util.Arrays;

public class tmp {

    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];

        int[][] map = new int[mat.length][2];

        for(int i = 0;i<mat.length;i++){
            int score = getCore(mat[i]);
            map[i] = new int[]{i,score};
        }

        System.out.println(Arrays.deepToString(map));

        Sort(map);
        System.out.println(Arrays.deepToString(map));
        for(int i = 0;i<k;i++){
            res[i] = map[i][0];
        }
        return res;
    }

    private void Sort(int[][] array){
        Sort(array,0,array.length-1);
    }

    private void Sort(int[][] array,int low,int high){
        if(low > high) return;
        System.out.println("low = " + low + " high = " + high );
        int mid = partition(array,low,high);
        System.out.println("low = " + low + " high = " + high  + " mid = " + mid);
        System.out.println(Arrays.deepToString(array));


        Sort(array,low,mid-1);
        Sort(array,mid+1,high);
    }


    private int partition(int[][] array,int low,int high){
        int pivot = array[low][1];
        int index = array[low][0];

        int start = low + 1;
        int end = high;

        while(end >= start){

            if(array[end][1] > pivot || (array[end][1] == pivot && array[end][0]> index) ){
                end--;
            }else if(array[start][1] < pivot || (array[start][1] == pivot && array[start][0] < index) ){
                start++;
            }else{
                // end < pivot && start >= pivot
                int[] tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
        //start = end + 1
        int[] tmp = array[low];
        array[low]= array[end];
        array[end] = tmp;


        return end;

    }




    private int getCore(int[] arr){
        return findIndex(arr) ;
    }

    private int findIndex(int[] arr){
        int low = 0;
        int high = arr.length - 1;

        int res = -1;
        while(high >= low){
            int mid = (high - low)/2 + low;

            if(arr[mid] == 0){
                high = mid - 1;
            }else{
                res = mid;
                low = mid + 1;
            }
        }

        return res + 1;
    }


    public static void main(String[] args) {
        //int[][] arr = new int[][]{{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};

        //int[][] arr = new int[][]{{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        int[][] arr = new int[][]{{1,0},{0,0},{1,0}};
        tmp v = new tmp();
        int[] ints = v.kWeakestRows(arr, 3);

        System.out.println(Arrays.toString(ints));
    }
}
