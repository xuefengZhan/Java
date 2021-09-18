package _15_多线程._01_线程的创建;

import org.junit.Test;

public class _01_Thread {

    public static void main(String[] args) {
        Thread.currentThread().setName("Main");

        new MyThread("MyThrea").start();

        for (int i = 0; i < 100; i++) {
            String name = Thread.currentThread().getName();
            System.out.println(name + " " + i);
        }
    }
}
class MyThread extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(this.getName() + i);
        }
    }

    public MyThread() {
    }

    public MyThread(String name) {
        super(name);
    }
}
