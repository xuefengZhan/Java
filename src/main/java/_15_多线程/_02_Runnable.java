package _15_多线程;

import org.junit.Test;

public class _02_Runnable {

    @Test
    public void test01(){

        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main: " + i);
        }
    }

    //todo runnable的优点：
    // 单继承特性，避免
    //
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyRunnable: "+ i);
        }
    }
}
