package _15_多线程;

import org.junit.Test;

public class _01_Thread {
    /*
        todo 1.Java的程序入口为main方法，也就是主线程
        线程是进程其中一条之星路径，一个进程至少有一个线程。main线程是java程序进程的第一个线程
        todo 2.如何开启main线程以外的线程？
            JavaSE阶段两种方式，后面还有别的方式
            方式1：继承Thread类
            方式2：实现Runnable接口
     */



    //todo 1. 继承Thread类  java.lang.Thread类
    //        重写run()，run()中编写此线程要完成的任务
    //        启动线程： start()
    //          如果直接调用run() 则当做一个普通方法
    @Test
    public void test01(){
        MyThread myThread = new MyThread();
        //启动线程
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main: " + i);
        }
        //非顺序执行，资源抢占式  并发执行
        // 注意：start()之后，线程之间才开始抢占资源
        // start()之前还是顺序执行
    }

    @Test
    public void test02(){
        MyThread myThread = new MyThread();

        //在start()之前 执行，先执行完这个
        for (int i = 0; i < 100; i++) {
            System.out.println("main: " + i);
        }
        //启动线程
        myThread.start();


    }
}
class MyThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyThread： " + i);
        }
    }
}
