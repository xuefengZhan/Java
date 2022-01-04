package Part3_面向对象编程;

public class _04_传参 {
    public static void main(String[] args){
        int a = 10;

        System.out.println("修改之前a = " + a);//10

        //a是实参
        change(a); // todo num=a   这意味着如果传的是引用，那么就把对象的引用传递过去了

        System.out.println("修改之后a = " + a);//10
    }

    public static void change(int num){
        System.out.println("修改之前num = " + num);//10

        num *=  2;

        System.out.println("修改之后num = " + num);//20
    }
}
