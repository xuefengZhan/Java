package 二分查找;

public class No278_第一个错误的版本 {
    public int firstBadVersion(int n) {
        int start  = 1;
        int end = n;

        while(start < end){
            int mid = start + ((end - start)>>1);
            if(isBadVersion(mid)){
                end = mid;
            }else{
                start = mid + 1;
            }
        }

        //start >= end
        return start;
    }



    private boolean isBadVersion(int n ){
        return n == 4;
    }
}
