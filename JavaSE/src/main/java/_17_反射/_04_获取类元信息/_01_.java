package _17_反射._04_获取类元信息;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Map;

public class _01_ {
    //todo 1.获取类的类加载器
    @Test
    public void test(){
        System.out.println("".getClass().getClassLoader());//null
    }

    //todo 2.获取包信息
    @Test
    public void test2(){
        Package aPackage = _01_.class.getPackage();
        String name = aPackage.getName();
        System.out.println(name); //_17_反射._04_获取类元信息
    }

    //todo 3.获取类名
    @Test
    public void test3(){
        //java.lang.String
        System.out.println(String.class.getName());
        //int
        System.out.println(int.class.getName());
        //[I
        System.out.println(int[].class.getName());
        //[[[I
        System.out.println(int[][][].class.getName());
        //[Ljava.lang.Object;
        System.out.println(Object[].class.getName());
    }

    //todo 4.获取类的修饰符
    @Test
    public void test4(){
        //public final class String
        int modifiers = String.class.getModifiers();
        System.out.println(modifiers);//17
        System.out.println(Modifier.toString(modifiers));//public final
    }

    //todo 5.获取内部类 或者 外部类
    @Test
    public void test5(){
        Class<?> clazz = Map.class;
        Class<?>[] inners = clazz.getDeclaredClasses();
        for (Class<?> inner : inners) {
            System.out.println(inner);
        }
        //interface java.util.Map$Entry

        Class<?> ec = Map.Entry.class; //内部接口
        Class<?> outer = ec.getDeclaringClass();
        System.out.println(outer);
        //interface java.util.Map
    }

    //todo 6. 获取构造器
    @Test
    public void test6() throws Exception{
        Class<?> clazz = Outer.class;
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        System.out.println(constructor);//无参构造

        Class<?> c = Outer.Inner.class;
        //因为Inner是非静态的内部类，所以它的构造器，默认第一个形参是外部类的实例对象
        Constructor<?> cs = c.getDeclaredConstructor(Outer.class);
        System.out.println(cs);
    }


    //todo 7.获取类中的方法
    @Test
    public void test9(){
        Class<?> clazz = String.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            int mod = method.getModifiers();
            Class<?> returnType = method.getReturnType();
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            System.out.print(Modifier.toString(mod)+"\t" + returnType + "\t" + name + "(");
            System.out.println(Arrays.toString(parameterTypes)+")");
        }
    }

    //todo 8.获取泛型类
    @Test
    public void test10(){
        Class<?> c = Base.class;
        TypeVariable<?>[] typeParameters = c.getTypeParameters();
        for (TypeVariable<?> typeVariable : typeParameters) {
            System.out.println(typeVariable + "，上限：" + typeVariable.getBounds()[0]);
        }

        Class<Sub> clazz = Sub.class;
        Type gs = clazz.getGenericSuperclass();

        ParameterizedType gt = (ParameterizedType)gs;
        Type[] types = gt.getActualTypeArguments();
        for (Type type : types) {
            System.out.println(type);
        }
    }

}

class Outer{
    class Inner{

    }
}

class Base<T extends Number>{

}
class Sub extends Base<Integer>{

}