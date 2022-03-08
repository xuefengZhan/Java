package 滑动窗口;


import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * mid
 *
 * 69.8%
 */

public class No3_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        //todo 1.定义窗口 [left,right] 没有重复元素
        int left = 0;
        int right = 0;

        int res = 1;
        //todo 2.定义map 存储窗口内的元素
        char[] chars = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        map.put(chars[0],0);

        while(right < s.length()-1){
            char element = chars[right+1];

            //如果窗口中包含
            //update res
            //窗口删除数据
            //移动左指针 和 右指针
            //窗口更新该元素索引
            if(map.containsKey(element)){
                Integer index = map.get(element);
                for(int i = left;i<= index;i++){
                    map.remove(chars[i]);
                }
                left = index + 1;
            }
            map.put(element,++right);
            res = Math.max(right - left + 1,res);

        }
        return res;
    }

    public static void main(String[] args) {
        No3_无重复字符的最长子串 v = new No3_无重复字符的最长子串();
        String s = "au";
        int res = v.lengthOfLongestSubstring(s);

        System.out.println(res);
    }
}
