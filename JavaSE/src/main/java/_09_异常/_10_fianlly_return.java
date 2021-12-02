package _09_异常;

public class _10_fianlly_return {
    //day15. 08 finally和return混用
    public static void main(String[] args) {
        System.out.println(getNum(1));//异常

        System.out.println(getNum2(1));//最终
        //todo 结论1：try-catch-finally中都有return语句：
        //    无论catch是否抓住了异常，都是从finally的return返回

        System.out.println(getNum3(1));
        //finally
        //异常
        //todo 结论2：try-catch中有return，finally中没有return
        // 先将try和catch中该执行的执行完，
        // 在return结束当前方法之前，先执行finally，然后回去执行return，结束方法



        System.out.println(getNum4(1));
        //catch
        //finally
        //0    注意：finally中赋值语句不影响catch中的赋值语句

        System.out.println(getNum5(1));
        //catch
        //finally
        //30
        // todo 可以这么理解
        //  catch中的result和finally中的result
        //  作用域不同，二者同名但是互不影响



    }

    public static String getNum(int a ){
        try{
            System.out.println(a/0);
            if(a>0){
                return "正";
            }else if(a<0){
                return "负";
            }else{
                return "零";
            }
        }catch(Exception e){
            return "异常";
        }
    }

    public static  String getNum2(int a ){
        try{
            System.out.println(a/0);
            if(a>0){
                return "正";
            }else if(a<0){
                return "负";
            }else{
                return "零";
            }
        }catch(Exception e){
            return "异常";
        }finally{
            return "最终";
        }
    }

    public static  String getNum3(int a ){
        try{
            System.out.println(a/0);
            if(a>0){
                return "正";
            }else if(a<0){
                return "负";
            }else{
                return "零";
            }
        }catch(Exception e){
            return "异常";
        }finally{
            System.out.println("finally");
        }
    }

    public static  int getNum4(int a ){
        int result = 10;
        try{
            System.out.println(a/0);
            if(a>0){
                result = 20;
                return result;
            }else if(a<0){
                result = -20;
                return result;
            }else{
                return result;
            }
        }catch(Exception e){
            System.out.println("catch");
            result = 0;
            return result;
        }finally{
            result =30;
            System.out.println("finally");
        }
    }


    public static  int getNum5(int a ){
        int result = 10;
        try{
            System.out.println(a/0);
            if(a>0){
                result = 20;
                return result;
            }else if(a<0){
                result = -20;
                return result;
            }else{
                return result;
            }
        }catch(Exception e){
            System.out.println("catch");
            result = 0;
            return result;
        }finally{
            result =30;
            System.out.println("finally");
            return result;
        }
    }
}
