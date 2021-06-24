package _19_代理模式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理：
// 一个代理类可以代理多个主题工作，只要代理的工作内容都一样就行
//需要：
//(1)编写一个代理工作处理器的类，这个类必须实现一个接口InvocationHandler
//(2)使用JDK中提供的一个Proxy类，来创建代理类的对象
//(3)调用方法
public class TestAgent2 {
    public static void main(String[] args) {
//        第一个参数是：被代理者的类加载器对象
//        参数2：被代理者实现的接口们
//        3：代理者替被代理者要完成的工作的处理器对象
//        Class<A> ac = A.class;
//        ClassLoader acl = ac.getClassLoader();
//        Class<?>[] interfaces = ac.getInterfaces();
//        Handler handler = new Handler(new AImpl());
//         //生成A的代理者对象
//        A Aproxy = (A) Proxy.newProxyInstance(acl, interfaces, handler);
//        Aproxy.a();
        //上面这种写法报错

        AImpl a = new AImpl();
        ClassLoader classLoader = a.getClass().getClassLoader();
        Class<?>[] interfaces = a.getClass().getInterfaces();
        A Aproxy =(A) Proxy.newProxyInstance(classLoader, interfaces, new Handler(a));
        Aproxy.a();

    }
}

//主题1：
interface A{
    void a();
}

//主题1的被代理者
class AImpl implements A{
    @Override
    public void a(){
        System.out.println("a方法被执行");
    }
}

//主题2：
interface B{
    void b();
}
//主题2 的被代理者
class BImpl implements B{
    @Override
    public void b(){
        System.out.println("b方法被执行");
    }
}
//代理类  实现InvocationHandler接口
class Handler implements InvocationHandler {
    private Object target;//被代理者对象

    public Handler(Object target) {
        this.target = target;
    }

    //参数1：代理类的对象
    //参数2：被代理者要执行的方法
    //参数3：被代理者要执行的方法需要的实参列表
    //这个方法不是程序调用的，是执行代理类对象的方法时自动调用的
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "被执行");
        long start = System.currentTimeMillis();

        //核心业务逻辑交给被代理者自己完成
        Object value = method.invoke(target,args);

        long end = System.currentTimeMillis();
        System.out.println("运行时间："+(end - start));
        System.out.println("add方法执行结束");

        return value;//被代理的方法反悔什么值 就返回什么
    }
}