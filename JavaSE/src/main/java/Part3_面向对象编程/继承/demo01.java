package Part3_面向对象编程.继承;

public class demo01 {
    public static void main(String[] args) {

        Father f = new Father();
        Son1 s = new Son1();
        System.out.println(f.getInfo());  //爸爸
        System.out.println(s.getInfo());  //爸爸
        s.test(); //爸爸 //爸爸


        System.out.println("-----------------");


        System.out.println(f.info);   //爸爸
        System.out.println(s.info);   //儿子

        s.setInfo("大头儿子");
        System.out.println(f.info);   //爸爸
        System.out.println(s.info);   //儿子
        System.out.println(f.getInfo()); //爸爸
        System.out.println(s.getInfo());  //大头儿子
        s.test();   //儿子  大头儿子
        s.test2(); //儿子  大头儿子
    }

}
class Father {
    public String info = "爸爸";

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class Son1 extends Father {
    //public String info = "儿子";

    public void test() {
        System.out.println(this.getInfo());
        System.out.println(super.getInfo());
    }
    public void test2(){
        System.out.println(this.info);
        System.out.println(super.info);
    }
}
