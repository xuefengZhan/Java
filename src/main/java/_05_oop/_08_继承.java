package _05_oop;

/**
 * @auther ZXF Fantasy
 * @create 2020-08-03 9:34
 */
public class _08_继承 {
    public static void main(String[] args) {
        Father f = new Father();
        Son1 s = new Son1();
        System.out.println(f.getInfo());   // atguigu
        System.out.println(s.getInfo());   // atguigu
        s.test(); // atguigu  atguigu
        System.out.println("-----------------");
        System.out.println(f.info);   // atguigu
        System.out.println(s.info);   // 尚硅谷
        s.setInfo("大硅谷");   // s对象中 super.Info变为大硅谷
        System.out.println(f.info);   // atguigu
        System.out.println(s.info);   // 尚硅谷
        System.out.println(f.getInfo());  // atguigu
        System.out.println(s.getInfo());  // 大硅谷
        s.test();   // 大硅谷  大硅谷
        s.test2();  // 尚硅谷  大硅谷


    }
}

class Father {
    public String info = "atguigu";

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}

class Son1 extends Father {
    public String info = "尚硅谷";

    public void test() {
        System.out.println(this.getInfo());
        System.out.println(super.getInfo());
    }
    public void test2(){
        System.out.println(this.info);
        System.out.println(super.info);
    }
}

//todo 说明
// 继承 然后有同名属性，那么该类中有this.info 和super.info
//     继承过来的setInfo和getInfo 是操作super.info的