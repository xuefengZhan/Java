package _05_oop;

public class _07_封装 {
//public：公共的，可用于修饰类、属性、方法。表示在其他任何想要使用的地方都可见。
//protected：受保护的，可用于修饰属性、方法。表示在本包或其他包的子类中可见。
//缺省的：可用于修饰类、属性、方法。表示在本包下可见。
//private：私有的，可用于修饰属性、方法、内部类、构造器。只能在本类中可见，本类以外的地方不可见。
    private class A {

    }
    protected class B{

    }
    protected _07_封装(){

    }
    _07_封装(int i){}

    //todo 只有public 和 缺省可以修饰外部类
    // 四个都可以修饰 属性、方法、内部类、构造器
}
