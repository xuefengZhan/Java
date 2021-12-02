package _18_工厂模式;

import org.junit.Test;

// 出发点：
// 为了生产对象和使用对象分开 ，使用的时候不用自己创建对象
// 增加新产品，就不需要修改原来的工厂类
public class TestFactory2 {
    @Test
    public static void main(String[] args) {
        MathFactory mf = new MathFactory();
        book book = mf.getBook();
        book.read();
    }
}

interface book{
    void read();
}
class Math implements book{

    @Override
    public void read() {
        System.out.println("数学");
    }
}
class Wuli implements book{

    @Override
    public void read() {
        System.out.println("物理");
    }
}
//todo 1.工厂接口
interface GongChang{
    book getBook();
}
//todo 2.
class MathFactory implements GongChang{
    @Override
    public book getBook(){
        return new Math();
    }
}

class WuliFactory implements GongChang{
    @Override
    public book getBook(){
        return new Wuli();
    }
}

//todo 如果多了一个种类的书
//  只需 增加一个对应的工厂类
//  可以增加新的类 但是不要修改原来的类
//  缺点：一个产品对应一个工厂   类太多了

