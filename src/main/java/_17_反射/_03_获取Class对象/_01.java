package _17_反射._03_获取Class对象;


import org.junit.Test;

public class _01 {
    @Test
    public void test(){
        Class<Integer> integerClass = int.class;
        Class<Void> voidClass = void.class;
        Class<String> stringClass = String.class;
        Class<_01> aClass = _01.class;
        Class<int[]> aClass1 = int[].class;
        Class<Override> overrideClass = Override.class;


        // Student类编译期间不存在，不可以用这种方式
        // Class<Student> studentClass = Student.class;


    }
}
