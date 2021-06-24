package _17_反射._04_反射应用;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class _06_ {
    //todo 获取父类泛型实参

    public static void main(String[] args) {
        //step1.获取Class对象
        Class clazz = Son.class;
        //step2.获取泛型父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        //强转
        ParameterizedType type = (ParameterizedType)genericSuperclass;
        //step3.获取类型实参
        Type[] actualTypeArguments = type.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument);
            //class java.lang.Integer
            //class java.lang.String
        }

    }

    @Test
    public void test02(){
        MyTools my = new MyTools(); // 打印的是：_17_反射._04_反射应用.MyTools@5e8c92f4
        my.test();

    }


}

class Farther<T,U>{

}
class Son extends Farther<Integer,String>{

}

//应用场景说明：父类中获取子类的父类的泛型实参
//在创建对象的时候，也就是构造器中获取可以根据要创建的对象获取父类泛型实参
class Tools<T>{
    //3.
    private Class type;
    public Tools(){
        //4.在创建子类对象的时候，来确定type的类型
        Class clazz = this.getClass();//这个this 是正在new的对象，并非Tools对象
        //4.1 测试 System.out.println(this);
        //5.获取泛型父类信息
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType t = (ParameterizedType) genericSuperclass;
        //6.获取父类泛型参数列表
        java.lang.reflect.Type[] actualTypeArguments = t.getActualTypeArguments();

        type = (Class) actualTypeArguments[0];
    }

    public void test(){
        //1.这个方法要用到T的Class对象
        //Class c = T.class; 无法确定T的类型，不可直接使用
        System.out.println(type);  //class java.lang.String
    }
}

//2.子类继承，指定泛型实参
class MyTools extends Tools<String>{

}
