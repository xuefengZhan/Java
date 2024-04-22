package dp.记忆化搜索;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName leetcode_241_为运算表达式设计优先级
 * @Author zxf
 * @Date 2024/3/11 14:19
 * @Questinon Describrition
 **/
public class leetcode_241_为运算表达式设计优先级 {
    static final int ADDITION = -1;
    static final int SUBTRACTION = -2;
    static final int MULTIPLICATION = -3;

    List<Integer>[][] dp ;
    public List<Integer> diffWaysToCompute(String expression) {
        //将exp转换成数组
        List<Integer> exp = new ArrayList<>();

        int l = 0;
        int r = 1;
        while(r <= expression.length()){
            if( r == expression.length()){
                exp.add(Integer.parseInt(expression.substring(l,r)));
                break;
            }

            char cur = expression.charAt(r);
            if( cur == '+' ){
                exp.add(Integer.parseInt(expression.substring(l,r)));
                exp.add(ADDITION);
                l = r + 1;
                r = l + 1;
            }else if(cur == '-'){
                exp.add(Integer.parseInt(expression.substring(l,r)));
                exp.add(SUBTRACTION);
                l = r + 1;
                r = l + 1;
            }else if(cur == '*'){
                exp.add(Integer.parseInt(expression.substring(l,r)));
                exp.add(MULTIPLICATION);
                l = r + 1;
                r = l + 1;
            }else{
                r++;
            }
        }


        int n = exp.size();
        dp = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }

        return dfs(0,exp.size() - 1,exp);
    }

    /**
     *
     * @param left   左边界（数字）
     * @param right  右边界（数字）
     * @return 返回[left,right]区间的所有结果
     */
    private List<Integer> dfs( int left,int right,List<Integer> exp ){
        if(dp[left][right].isEmpty()){
            if(left == right){
                dp[left][right].add(exp.get(left));
            }else{
                //遍历left到right的所有运算符
                for (int i = left + 1; i < right; i = i + 2) {
                    List<Integer> ls = dfs(left,i-1,exp); //运算符左边的结果集
                    List<Integer> rs = dfs(i+1,right,exp); //运算符右边的结果集

                    for (Integer l : ls) {
                        for (Integer r : rs) {
                            if(exp.get(i) == ADDITION){
                                dp[left][right].add(l+r);
                            }else if(exp.get(i) == SUBTRACTION){
                                dp[left][right].add(l-r);
                            }else{
                                dp[left][right].add(l*r);
                            }
                        }
                    }
                }
            }

        }
        return dp[left][right];
    }




    public static void main(String[] args) {
        leetcode_241_为运算表达式设计优先级 v = new leetcode_241_为运算表达式设计优先级();
        String expression = "2*3-4*5";
        System.out.println(Integer.parseInt(expression.substring(0,1)));
        List<Integer> res = v.diffWaysToCompute(expression);

        System.out.println(res);
    }


}
