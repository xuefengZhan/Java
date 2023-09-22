package 二分查找;

/**
 * @ClassName leetcode_1095_山脉数组中查找目标值
 * @Author zxf
 * @Date 2023/3/9 15:15
 **/


public class leetcode_1095_山脉数组中查找目标值 {


    public int findInMountainArray(int target, MountainArray mountainArr) {
        int index = findMax(mountainArr);
        int left = findTarget(target,mountainArr,0,index,true);

        if(left != -1) return left;

        return findTarget(target,mountainArr,index,mountainArr.length()-1,false);
    }


    private int findMax(MountainArray mountainArray){
        int low = 0;
        int high = mountainArray.length() - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            //以low和high不要漏掉最值为原则进行迭代

            // < 表示 index >= mid + 1
            if (mountainArray.get(mid) < mountainArray.get(mid + 1)) {
                low = mid + 1;
            } else {
                // >=  等于是不可能的  > 则表示index <= mid
                // high = mid 存在一个风险就是 当high = low 的时候陷入死循环
                high = mid;
            }
        }
        //low == high
        return low;
    }

    private int findTarget(int target,MountainArray mountainArray,int low,int high,boolean asc){


        while(high >= low){
            int mid = (high - low) / 2 + low;

            int res = mountainArray.get(mid);
            if(asc){
                if(res == target){
                    return mid;
                }else if(res > target){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(res == target){
                    return mid;
                }else if(res > target){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
