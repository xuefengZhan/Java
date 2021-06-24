package _19_代理模式;

import org.junit.Test;

// 应用场景： 红娘帮忙找女朋友，代购
// 静态代理模式
public class TestAgent{
    @Test
    public void test01(){
        //1.new UserDAOImpl() 被代理者对象
        //2.new DAOProxy(x)   代理者对象
        DAO d = new DAOProxy(new UserDAOImpl());
        d.add();

    }
}
//1.主题接口
interface DAO{
    void add();
}

//2.被代理类
class UserDAOImpl implements DAO{

    @Override
    public void add() {
      //  System.out.println("add方法开始执行");
      //  long start = System.currentTimeMillis();

        System.out.println("添加商品");

//        long end = System.currentTimeMillis();
//        System.out.println("运行时间："+(end - start));
//        System.out.println("add方法执行结束");
    }
}
//3.代理类
// 代理类要做的事情：被代理类要做的事情+额外的事情
// 代理类为什么也要继承被代理类的接口？
//  1.代理类必须和被代理类 保持一个主题
//  2.且代理的方法名要保持一致
// 代理类必须持有被代理者引用 因为核心业务要由被代理者自己完成
class DAOProxy implements DAO{
    private DAO dao;
    public DAOProxy(DAO dao){
        this.dao = dao;
    }
    public void add(){
        System.out.println("add方法开始执行");
        long start = System.currentTimeMillis();

        //核心业务逻辑交给被代理者自己完成
        //System.out.println("添加商品");
        dao.add();

        long end = System.currentTimeMillis();
        System.out.println("运行时间："+(end - start));
        System.out.println("add方法执行结束");
    }
}
//静态代理的缺点:
// 一个代理类只能代理一个主题(接口)工作

