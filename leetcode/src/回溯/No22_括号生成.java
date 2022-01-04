package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class No22_括号生成 {


    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        char[] chooses = {'(',')'};
        place(0,0,n,chooses,new StringBuilder());

        return res;
    }


    /**
     *
     * @param left   path中'('的个数
     * @param right  path中')'的个数
     * @param max    n
     * @param chooses  {'(',')'}
     * @param path
     */
    private void place(int left,int right,int max,char[] chooses,StringBuilder path){

        if(left > max || right > max || right > left){
            return ;
        }

        //todo 1.返回条件
        if(left == max && right == max){
            res.add(new String(path));
            return;
        }

        //todo 2.遍历
        for (char choose : chooses) {
            path.append(choose);

            if(choose == '('){
                left ++;
            }else{
                right ++;
            }

            place(left,right,max,chooses,path);
            path.deleteCharAt(path.length()-1);

            if(choose == '('){
                left --;
            }else{
                right --;
            }
        }
    }

    public static void main(String[] args) {
        No22_括号生成 v = new No22_括号生成();
        List<String> strings = v.generateParenthesis(3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
