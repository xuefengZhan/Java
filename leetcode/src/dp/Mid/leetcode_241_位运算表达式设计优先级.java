package dp.Mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName leetcode_241_位运算表达式设计优先级
 * @Author zxf
 * @Date 2023/8/30 16:31
 * @Questinon Describrition
 *
 *
 * 结果有点问题  重复的括号组合没有去重
 **/
public class leetcode_241_位运算表达式设计优先级 {
    List<Integer> res = new ArrayList<>();


    public List<Integer> diffWaysToCompute(String expression) {
        List<String> stringList = convert(expression);
        System.out.println(stringList);
        dfs(stringList);
        return res;
    }


    //将字符串形式的表达式转换成数组形式的
    private List<String> convert(String expression){
        List<String> res = new ArrayList<>();
        int prev = 0;
        for (int i = 0; i <= expression.length(); i++) {
            if(i == expression.length()){
                res.add(expression.substring(prev,i));
                prev = i+1;
            }else if(expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                res.add(expression.substring(prev,i));
                res.add(expression.charAt(i) + "");
                prev = i+1;
            }
        }

        return res;
    }
    private void dfs(List<String> expression){
        System.out.println("----------    expression == " + expression + "    ----------");

        if(expression.size() == 1){
            res.add(Integer.parseInt(expression.get(0)));
            return;
        }

        //当前选择 右边括号的位置
        for (int i = expression.size(); i >= 3 ; i-=2) {
            System.out.println("为"+expression+"做当下选择");
            System.out.println("expression == " + expression);

            //当前选择的子串
            List<String> calString = new ArrayList(expression.subList(i - 3, i));
            System.out.println("i == " + i);
            System.out.println("calString == " + calString);

            int cal = cal(calString);//-34


            List<String> newExpression = new ArrayList(expression.subList(0,i-3));
            newExpression.add(cal+"");
            newExpression.addAll(new ArrayList(expression.subList(i, expression.size())));
            System.out.println("newExpression == " + newExpression);


            dfs(newExpression);
        }


    }


    private int cal(List<String> s){
        int x = Integer.parseInt(s.get(0));
        int y = Integer.parseInt(s.get(2));

        System.out.println("s ==" + s);


        String sign = s.get(1);
        System.out.println("sign == " + sign );

        if(sign.equals("+")){
            return x+y;
        }
        if(sign.equals("-")){
            return x-y;
        }
        if(sign.equals("*")){
            return x * y;
        }

        return x / y;
    }


    public static void main(String[] args) {
        leetcode_241_位运算表达式设计优先级 v = new leetcode_241_位运算表达式设计优先级();

        String expression =  "2*3-4*5";

        List<Integer> integers = v.diffWaysToCompute(expression);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
