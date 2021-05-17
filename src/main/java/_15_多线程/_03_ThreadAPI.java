package _15_多线程;

import org.junit.Test;

public class _03_ThreadAPI {


    //todo 1.public static void sleep
    @Test
    public void test01(){
        for (int i = 10; i >= 1 ; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //todo 2.public String getName() 获取Thread的名字
    //todo 3.public static Thread currentThread() 获取当前正在运行的Thread对象
    @Test
    public void test02(){
        Thread t = Thread.currentThread();
        System.out.println(t.getName());//main
    }
}
