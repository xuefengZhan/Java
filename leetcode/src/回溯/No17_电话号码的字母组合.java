package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class No17_电话号码的字母组合 {

    List<String> res = new ArrayList<>();

    HashMap<Character, List<Character>> keyboard = new HashMap<>();

    {
        keyboard.put('2', Arrays.asList('a','b','c'));
        keyboard.put('3', Arrays.asList('d','e','f'));
        keyboard.put('4', Arrays.asList('g','h','i'));
        keyboard.put('5', Arrays.asList('j','k','l'));
        keyboard.put('6', Arrays.asList('m','n','o'));
        keyboard.put('7', Arrays.asList('p','q','r','s'));
        keyboard.put('8', Arrays.asList('t','u','v'));
        keyboard.put('9', Arrays.asList('w','x','y','z'));
    }

    public List<String> letterCombinations(String digits) {
        if("".equals(digits) || digits == null) return res;

        place(digits,0,new StringBuilder());

        return res;
    }


    private void place(String digits,int index,StringBuilder path){

        if(index == digits.length() ){
            res.add(new String(path));
            return ;
        }


        //todo 1.可选路径
        List<Character> chooses =  keyboard.get(digits.charAt(index));

        //todo 2.做出当下选择
        for (Character choose : chooses) {

            path.append(choose);

            place(digits,index+1,path);

            path.deleteCharAt(path.length() - 1);

        }


    }

    public static void main(String[] args) {
        No17_电话号码的字母组合 v = new No17_电话号码的字母组合();
        String digits =  "2";
        List<String> strings = v.letterCombinations(digits);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
