package _10_常用类.包装类;

import org.junit.Test;

public class _01_ {
    public void test01() {
        //todo 1.自动装箱
        int a = 10;
        Integer integer = new Integer(10);
        System.out.println(a);
        System.out.println(integer);
    }

    public void test02(){
        int a = 1;
        Integer b = 1;
        System.out.println(a == b);

        //todo 2.
        // 当基本数据类型和对象类型进行比较的时候，会对包装类型进行自动拆箱

        int c = 1;
        Double d = 1.0;
        System.out.println(c == d);

        //todo 2.1
        // 自动拆箱后的基本数据类型之间进行比较，所遵守的规则就是 自动向上转型


    }
    public void test03(){
        Integer a = 1;
        Double  b = 1.0;

        //System.out.println(a == b);   报错
        //todo 3.
        //  == 用于对象比较的时候，比较的是地址
        // 两个对象必须有父子关系或者同一类型才能比较

    }
}