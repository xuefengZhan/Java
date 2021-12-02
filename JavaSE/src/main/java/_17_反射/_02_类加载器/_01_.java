package _17_反射._02_类加载器;

import org.junit.Test;

public class _01_ {
    //todo 1.获取某个类的类加载器对象
    @Test
    public void test01(){
        // 普通类的类加载器
        Class clazz = _01_.class;
        ClassLoader loader = clazz.getClassLoader();
        System.out.println(loader);//sun.misc.Launcher$AppClassLoader@18b4aac2


        //rt.jar包下的类的类加载器
        Class<String> stringClass = String.class;
        ClassLoader classLoader = stringClass.getClassLoader();
        System.out.println(classLoader);//null
    }
}
