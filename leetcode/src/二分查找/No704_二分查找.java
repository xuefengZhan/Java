package 二分查找;

public class No704_二分查找 {
    public int search(int[] nums, int target) {


        //todo 1.定义区间  左臂右臂

            int start = 0;
            int end = nums.length -1;

        //todo 2.[start,end]  = > start == end的时候，还有效
            while(start <= end){
                int mid =  start + ((end - start) >> 1);

                //todo 3. 左闭右闭，将不符合的排除在外
                if(nums[mid] > target){
                    end = mid - 1;
                }else if(nums[mid] < target){
                    start = mid + 1;
                }else{
                    return mid;
                }
            }


        //todo 3. start > end 没找到
        //start = end + 1  => mid = start ,end = mid - 1;   start = end 或者 start = end - 1
        //start = end + 1  => end = mid,start = mid + 1;

            if(nums[start] > target){
                return start - 1;
            }
            else{
                return end + 1;
            }

        }
}
