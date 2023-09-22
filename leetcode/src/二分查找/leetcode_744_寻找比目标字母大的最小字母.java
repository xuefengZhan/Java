package 二分查找;

/**
 * @ClassName leetcode_744_寻找比目标字母大的最小字母
 * @Author zxf
 * @Date 2023/4/18 9:51
 **/
public class leetcode_744_寻找比目标字母大的最小字母 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;

        int res = 0;

        while(left <= right){
            int mid = (right - left) / 2 + left;

            if(letters[mid] <= target){
                left = mid + 1;
            }else{
               // letters[mid] > target
                res = mid;
                right = mid - 1;
            }
        }
        return letters[res - 1];
    }
}
