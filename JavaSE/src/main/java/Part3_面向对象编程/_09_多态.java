package Part3_面向对象编程;

public class _09_多态 {
    public void getName(Farther f){
        f.name();
    }
    public void getName(Son s){
        s.name();
    }

    public static void main(String[] args) {
        _09_多态 t = new _09_多态();
        Farther f1 = new Farther();
        Farther f2 = new Son(); //todo f2是Farther引用，son对象
        Son s = new Son();

        t.getName(f1);//一代目
        t.getName(f2);//二代目
        t.getName(s);//二代目

        System.out.println(f1.name);//波风水门
        System.out.println(f1.fa);//1
        f1.fight();//WDNMD

        System.out.println(f2.name);//todo 波风水门   属性没多态
        System.out.println(f2.fa);//todo 1  静态属性也没多态
        f2.fight();//todo 静态方法也没有多态 WDNMD   静态方法调用father类的

        System.out.println(s.name);//漩涡鸣人
        System.out.println(s.fa);//2
        s.fight();//你怎么不打你妈


        //todo instanceof
        System.out.println(s instanceof Farther);


    }

    static class Farther{
        String name = "波风水门";
        public void name(){
            System.out.println("一代目");

        }
        public static int fa = 1;
        public static void fight(){
            System.out.println("WDNMD");
        }
    }
    static class Son extends Farther{
        String name = "漩涡鸣人";

        public void name(){
            System.out.println("二代目");
        }
        public static int fa = 2;
        public static void fight(){
            System.out.println("你怎么不打你妈");
        }
    }

}

