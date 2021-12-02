package _16_单例模式;


import org.junit.Test;

//单例实现
//单例和枚举一样的
// todo 饿汉式：不管用不用这个对象，都立马创建好这个对象
//      懒汉式：用到这个对象才创建这个对象

public class Test1{
    @Test
    public void test(){
        SingleEnum s1 = SingleEnum.INSTANCE;
        SingleEnum s2 = SingleEnum.INSTANCE;

        System.out.println(s1 == s2);
    }
    @Test
    public void test2(){
        SingleEnum.test();//即使没有用到这个对象，也被创建出来了
    }




    //线程存在安全问题
    singleClass3 s1;
    singleClass3 s2;
    @Test
    public void test3(){
        Thread t1 = new Thread(){
            public void run(){
                s1 = singleClass3.getInstance();
            }
        };


        Thread t2 = new Thread(){
            public void run(){
                s2 = singleClass3.getInstance();
            }
        };

        t1.start();
        t2.start();

       //让t1和t2都执行完 再走下面
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1==s2);

        //_16_单例模式.singleClass3@2957fcb0
        //_16_单例模式.singleClass3@1376c05c
        //false

    }
}
//todo 饿汉式实现方式1： 枚举实现
enum SingleEnum{
    INSTANCE;

    public static void test(){
        System.out.println("en");
    }
}


//todo 饿汉式实现方式2： 和枚举类的实现原理是一样的
class singleClass{

    //2.提供public static final的实例属性
    public static final singleClass INSTANCE = new singleClass();


    //1.私有化构造器
    private singleClass(){}
}

//todo 饿汉式实现方式3：暴露方法 而非属性
class singleClass2{

    //2.实例属性私有化
    private static final singleClass2 INSTANCE = new singleClass2();


    //1.私有化构造器
    private singleClass2(){}

    //3.暴露静态方法来获取对象，而非直接通过属性获取
    public static singleClass2 getInstance(){
        return INSTANCE;
    }
}
//todo 懒汉式实现方式1：存在线程安全问题
class singleClass3{
    //2.不能用final，因为final的话，必须要初始化！
    private static  singleClass3 instance;

    //1.私有化
    private singleClass3(){}

    //3.在调用获取对象的方法的时候再创建
    public static singleClass3 getInstance(){
        // return new singleClass3(); 这样每次调用这个方法都会创建新的对象

        if(instance == null){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new singleClass3();
        }
        return instance;
    }
}

//todo 懒汉式实现方式2：解决线程安全问题
//     方式1：直接将getInstance()变为同步方法：public synchronized static singleClass3 getInstance()
//      效率低，没有必要每隔线程都要等待锁之后才能获取对象
//     方式2：双层嵌套  效率最优
class singleClass4{
    //2.不能用final，因为final的话，必须要初始化！
    private static  singleClass4 instance;

    //1.私有化
    private singleClass4(){}

    //3.在调用获取对象的方法的时候再创建
    public static singleClass4 getInstance(){
        //静态方法中不能出现this，可以用当前类的Class对象
        // 也可以自己造一个锁对象
        // 但是这个效率和同步方法是一样的，也是线程先获取锁，才能获取instance对象
//        synchronized(singleClass4.class){
//            if(instance == null){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                instance = new singleClass4();
//            }
//            return instance;
//        }


        //todo 效率最优且
        // 如果instance == null ，那么线程获取锁，来创建对象
        // 如果instance != null，那么线程根本不用获取锁了，直接获取instance
        if(instance == null){
            synchronized(singleClass4.class){
                if(instance == null){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new singleClass4();
                }
            }
        }
        return instance;

        //todo 第一个instance== null判断是为了提高效率，只有第一个线程需要获取锁资源创建对象
        //                 后续线程不用获取锁了，直接获取对象
        //     第二个instance==null 判断是为了线程安全问题
        //              只有instance==null的时候，才需要创建新的对象
        //     假设线程1，走到第一个instance==null之后，cpu被线程2抢去了，线程2拿到了锁创建了对象
        //     线程2执行完毕，线程1拿到cpu，如果没有第二次判断，会导致创建一个新的对象
    }
}

//todo 懒汉式实现方式3：内部类形式
// 线程安全且简单
class singleClass5{
    //1.
    private singleClass5(){}
    //2.内部类
    static class Inner{
        public static final singleClass5 INSTANCE = new singleClass5();
    }

    //3.获取  内部类的初始化是使用的时候才初始化
    public static singleClass5 getInstance(){
        return Inner.INSTANCE;
    }
}
