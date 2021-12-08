public class _1005 {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        if(k == 0){
            int sum = 0;
            for(int i = 0;i<nums.length;i++){
                sum += nums[i];
            }
            return sum;
        }

        int preMax = largestSumAfterKNegations(nums,k - 1);

        int minIndex = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
        }

        int min = nums[minIndex];
        nums[minIndex] = -nums[minIndex];
        return preMax - ( min << 1) ;
    }

    public static void main(String[] args) {
        int i = largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3);
        System.out.println(i);
    }
}
