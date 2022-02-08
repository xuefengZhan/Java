package dp;

public class NC19_连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {

        if(array.length == 1) return array[0];

        int max = array[0];
        int prev = array[0];
        for(int i = 1;i<array.length;i++){
            int maxI ;
            if(prev > 0){
                maxI = prev +array[i];
            }else{
                maxI = array[i];
            }
            prev = maxI;
            max = Math.max(maxI,max);
        }
        return max;
    }

    public static void main(String[] args) {
        NC19_连续子数组的最大和 v = new NC19_连续子数组的最大和();
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        int i = v.FindGreatestSumOfSubArray(arr);
        System.out.println(i);
    }
}
