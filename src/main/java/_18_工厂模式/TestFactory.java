package _18_工厂模式;

import org.junit.Test;

import java.sql.SQLOutput;

public class TestFactory {
    @Test
    public void test01(){
        BMW b = new BMW();
        b.run();

    }

    @Test
    public void test02(){
        car car = SimpleFactory.getCar();
        car.run();
    }


    @Test
    public void test03(){
        car car = SimpleFactory2.getCar("奔驰");
        car.run();
    }
}

interface car{
    void run();
}

class BMW implements car{
    @Override
    public void run(){
        System.out.println("宝马");
    }
}

class Benz implements car{
    @Override
    public void run(){
        System.out.println("奔驰");
    }
}

//1.简单工厂
class SimpleFactory{
    public static car getCar(){
        return new BMW(){};
    }
}
//2.
class SimpleFactory2{
    public static car getCar(String type){
        if("宝马".equals(type)){
            return new BMW();
        }else if("奔驰".equals(type)){
            return new Benz();
        }else{
            return null;
        }
    }
}
//todo 简单工厂
// 缺点，如果增加了车的种类，要修改工厂的方法
// 违反了设计规则
