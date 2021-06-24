package _17_反射._04_反射应用;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Properties;

public class TestClassInfo {
    //在框架中，例如Spring框架，会帮我们管理很多的类
    //这些类不是Spring写好的类，而是我们后期自己写的，
    //然后再运行期间，Spring去加载获取的


    //todo step1.获取类的Class对象
    //     step2.获取类的信息
    Class clazz;
    @Before
    public void test01() throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        InputStream in = TestClassInfo.class.getClassLoader().getResourceAsStream("Bean.properties");
        properties.load(in);

        String className = properties.getProperty("className");

        clazz = Class.forName(className);
    }

    @Test
    //2.获取类的信息
    public void test02(){
        //(1)类所在的获取包名
        Package pkg = clazz.getPackage();
        System.out.println(pkg.getName()); //_01_

        //(2)获取类全名
        String name = clazz.getName();
        System.out.println(name);//_01_.AtGuiguDemo

        //(3)获取类的修饰符
        int modifiers = clazz.getModifiers();
        System.out.println(modifiers);       //1
        System.out.println(Modifier.toString(modifiers)); //public

        //(4)获取父类名称
        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);//class java.lang.Object

        //(5)获取实现的接口
        Class[] interfaces = clazz.getInterfaces();//是个数组
        System.out.println(interfaces);           //[Ljava.lang.Class;@78e03bb5
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);    //interface java.io.Serializable
                                               //interface java.lang.Comparable
        }
        
        //(6)获取属性  属性是Field对象
        //所有类型在内存中都是Class对象
        //所有属性都是Field对象
        //属性类型：Field类型
        //类的概念：具有相同特性的食物的抽象描述
        //所有属性的相同特征： 1.都有修饰符、数据类型、名称
        //所有属性的相同行为： 1.get操作和set操作
        //所以将属性抽象为Field类
        Field[] fields = clazz.getFields();
        int count = 0;
        for (Field field : fields) {
            count++;
            System.out.println(count+"属性的修饰符为："+Modifier.toString(field.getModifiers()));
            System.out.println(count+"属性的数据类型为："+field.getType().getName());
            System.out.println(count+"属性的名称为：" + field.getName());
        }
        System.out.println(count);

        //(7)代码块
        //代码块编译后 融入了<init>()或者<clinit>()  因此无法通过Class获取代码块

        //(8)构造器
        //构造器其实也进入了<init>()中，所以这里所说的获取构造器
        //其实是获取<init>() 实例初始化方法
        //一个构造器对应一个<init>()
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("构造器的修饰符为："+Modifier.toString(constructor.getModifiers()));
            System.out.println("构造器的名称："+constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            System.out.println("构造器的形参列表：" + Arrays.toString(parameters));
            //构造器的修饰符为：public
            //构造器的名称：_01_.AtGuiguDemo
            //构造器的形参列表：[]
            //构造器的修饰符为：public
            //构造器的名称：_01_.AtGuiguDemo
            //构造器的形参列表：[int arg0, java.lang.String arg1, int arg2]
        }
        //(9)获取方法
        //所有方法都有：修饰符，方法名，返回值类型，形参列表，异常列表
        //都可以：被调用
        Method[] declaredMethods = clazz.getDeclaredMethods();



    }
}
