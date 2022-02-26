package 滑动窗口;

/**
 *       x y z z a z
 *
 *       l
 *       r
 *
 *       x y z z a z
 *       l
 *         r
 *
 *        x y z z a z
 *        l
 *            r

 *        x y z z a z
 *        l
 *              r
 */



public class No1876_长度为三且各字符不同的子字符串 {
    public int countGoodSubstrings(String s) {
        if(s == null || s.length() < 3) return 0;
        //todo 1.初始化窗口
        int left = 0;
        int right = 0;


        int res = 0;

        //todo 2.定义窗口：不能容许窗口中出现2个一样的元素
        // 窗口：[left,right] 窗口大小 = right - left + 1


        while(right < s.length() - 1){
            //todo 移动右边的条件
            right++;



            //todo 移动左边的条件
            if(s.charAt(right)  == s.charAt(right - 1)){
                left = right;
            }else if(s.charAt(right) ==  s.charAt(left)){
                left++;
            }else if(right - left + 1 == 3){
                left ++;
                res ++;
            }

        }
        //right = chars.length - 1
        return res;
    }


    public static void main(String[] args) {
        No1876_长度为三且各字符不同的子字符串 v = new No1876_长度为三且各字符不同的子字符串();
        String str = "aababcabc";
        int i = v.countGoodSubstrings(str);
        System.out.println(i);
    }
}
