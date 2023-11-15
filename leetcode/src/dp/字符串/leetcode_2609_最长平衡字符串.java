package dp.字符串;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Date 2023/11/8 0:41
 * @Author 詹学丰
 * @Name leetcode_2609_最长平衡字符串
 * @QUESTION DESCRIPTION
 * @TAG
 * @RESULT
 **/

public class leetcode_2609_最长平衡字符串 {
    public int findTheLongestBalancedSubstring(String s) {
        int zero = 0;
        int one = 0;

        int res = 0;


        boolean status = false;

        for (int i = 0; i < s.length(); i++) {

            if((i == 0 || s.charAt(i - 1) == '1') && s.charAt(i) == '0'){
                //此时开始新的计数
                status = true;
                zero = 1;
                one  = 0;
            }else if(status){
                if(s.charAt(i) == '0'){
                    zero++;
                }else{
                    one++;
                    if(one == zero){
                        res = Math.max(res,zero);
                        status = false;
                    }
                }
            }
        }

        return res;

    }
}
