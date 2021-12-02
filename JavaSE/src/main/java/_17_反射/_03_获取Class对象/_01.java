package _17_反射._03_获取Class对象;


import org.junit.Test;

import java.lang.annotation.ElementType;

public class _01 {
    @Test
    public void test(){
        //1.8种基本数据类型
        Class<Integer> integerClass = int.class;
        //2. void
        Class<Void> voidClass = void.class;
        //3. String
        Class<String> stringClass = String.class;
        //4. 类、接口
        Class<_01> aClass = _01.class;
        //5. 数组
        Class<int[]> aClass1 = int[].class;
        //6. 注解
        Class<Override> overrideClass = Override.class;


        // Student类编译期间不存在，不可以用这种方式
        // Class<Student> studentClass = Student.class;
    }
    @Test
    public void test2(){
        Class c1 = "".getClass();
        Class c2 = String.class;
        System.out.println(c1 == c2 );
    }

    @Test
    public void test3() throws ClassNotFoundException{
        Class<?> c1 = String.class;
        Class<?> c2 = "hello".getClass();
        Class<?> c3 = Class.forName("java.lang.String");
        Class<?> c4 = ClassLoader.getSystemClassLoader().loadClass("java.lang.String");
        System.out.println(c1 == c2);//true
        System.out.println(c1 == c3);//true
        System.out.println(c1 == c4);//true
    }
    @Test
    public void test4(){
        Class<?> c1 = int.class;//基本数据类型
        Class<?> c2 = void.class;//void类型

        Class<?> c3 = String.class;//类
        Class<?> c4 = Object.class;//类
        Class<?> c5 = Class.class;//类
        Class<?> c6 = Comparable.class;//接口

        //只要元素类型与维度一样，就是同一个Class
        Class<?> c7 = int[].class;
        int[] arr1 = new int[5];
        int[] arr2 = new int[10];
        System.out.println(arr1.getClass() == c7);//true
        System.out.println(arr2.getClass() == c7);//true
        Class c9 = String[].class;
        Class c10 = int[][].class;
        System.out.println(c7 == c9);//false
        System.out.println(c7 == c10);//false  维度不一样不是同一个

        Class c11 = Override.class;//注解
        Class c12 = ElementType.class;//枚举
    }
}
