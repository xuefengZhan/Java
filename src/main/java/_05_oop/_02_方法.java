package _05_oop;

public class _02_方法 {
    //todo 方法的声明
    // 权限修饰符   返回值  方法名(形参列表)
    public int func(int i){
        return i;
    }

    public void func2(int i ){
        System.out.println(i);
        return;
    }

    //todo 方法的调用
    // 本类中：直接用方法名即可调用
    //    注意：静态方法中不能访问非静态属性和方法
}
