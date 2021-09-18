package _15_多线程._01_线程的创建;

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

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("MyRunnable: "+ i);
        }
    }
}
