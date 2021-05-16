package _08_Enum;

public class _01_ {
    //todo 枚举类指的是该类只有有限个对象

    //todo 如何自定义枚举类？
    // 1.对象个数有限，因此构造器必须私有化，控制实例的创建
    // 2.类中提前创建好几个对象，供别人使用
        //1. static:构造器私有化，无法通过对象访问，必须为static变量才能通过类访问
        //2. public ： 可在类外被访问
        //3. final ：不可改变

}
class Season{
    public static final Season SPRING = new Season("Spring");
    public static final Season SUMMER = new Season("Summer");

    private String description;

    private Season(String description){
        this.description = description;
    }

    public String toString(){
        if(this == SPRING){
            return "SPRING";
        }else{
            return "SUMMER";
        }
    }
}

//JDK 1.5之后
enum Phone{

    //常量后面有值 调用的是有参构造
    HUAWEI("华为"),IPHONE,OPPO,VIVO;

    //枚举也是一种类
    private Phone(){

    }
    private Phone(String name){

    }

}
