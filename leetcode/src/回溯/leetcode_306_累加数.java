package 回溯;

/**
 * @ClassName leetcode_306_类家属
 * @Author zxf
 * @Date 2023/11/7 9:46
 * @Questinon Describrition
 **/
public class leetcode_306_累加数 {
    public boolean isAdditiveNumber(String num) {

        //第一位数的结尾索引
        for(int i = 1;i<num.length();i++){

            //如果第一个数字a不是0 则选下一个
            if(num.charAt(0) == '0' && i >  1) continue;
            long a = Long.parseLong(num.substring(0,i));
            System.out.println("i == " + i + "  a == " + a);
            for (int j = i+1; j < num.length(); j++) {

                if(num.charAt(i) == '0' && j > i + 1) continue;
                long b = Long.parseLong(num.substring(i,j));
                System.out.println("j == " + j + "  b == " + b);

                for(int k = j + 1 ; k <= num.length();k++){
                    if(num.charAt(j) == '0' && k > j + 1) continue;
                    long c = Long.parseLong(num.substring(j,k));
                    System.out.println("k == " + k + " c == " + c);
                    if(c < a + b) continue;
                    if(c == a + b){
                        System.out.println(a + " + " + b + " = " + c);
                        if(dfs(num,i,j,k)) return true;
                    }

                    break;
                }


            }
        }

        return false;
    }


    private boolean dfs(String num,int i , int j,int k){
        if(k == num.length()) return true;

        long a = Long.parseLong(num.substring(i,j));
        System.out.println("i == " + i + " j == " + j +  " a == " + a);
        long b = Long.parseLong(num.substring(j,k));
        System.out.println("j == " + j + " k == " + k +  " b == " + b);

        for (int m = k+1; m <= num.length(); m++) {
            if(num.charAt(k) == '0' && m > k + 1) continue;
            long c = Long.parseLong(num.substring(k,m));
            System.out.println(a + " + " + b + " = " + c);
            if(c < a + b) continue;

            if(c == a + b){
                return dfs(num,j,k,m);
            }else {
                break;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        leetcode_306_累加数 v = new leetcode_306_累加数();

        String num = "121224036";


        boolean res = v.isAdditiveNumber(num);


        System.out.println(res);
    }
}
