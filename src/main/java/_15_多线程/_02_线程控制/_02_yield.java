package _15_多线程._02_线程控制;

public class _02_yield {

    public static void main(String[] args) {
        MyYieldThread m1 = new MyYieldThread("低");
        m1.setPriority(Thread.MIN_PRIORITY);
        MyYieldThread m2 = new MyYieldThread("高");
        m2.setPriority(Thread.MAX_PRIORITY);

        m1.start();
        m2.start();
    }


}

class MyYieldThread extends Thread {

    public MyYieldThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(getName() + ":" + i);
            Thread.yield();
        }
    }
}