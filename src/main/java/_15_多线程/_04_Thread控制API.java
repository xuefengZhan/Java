package _15_多线程;

import org.junit.Test;

public class _04_Thread控制API {

    @Test
    //todo  打断别的线程休眠   抛出异常：InterruptedException
    // public void interrupt()
    public void test01(){
        thread1 my1 = new thread1();
        my1.start();

        //主线程休眠3s后，终端MyThread线程

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        my1.interrupt();

        //thread1
        //java.lang.InterruptedException: sleep interrupted
        //	at java.lang.Thread.sleep(Native Method)
        //	at _15_多线程.thread1.run(_04_Thread控制API.java:29)
        //自定义线程被打断
        //sleep over

    }

    @Test
    // todo 加塞
    //  public final synchronized void join(long millis)
    //    throws InterruptedException
    public void test02(){
        run1 run1 = new run1();
        Thread t = new Thread(run1);

        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("main" + i);
            //todo 当主线程打印到3的时候，主线程被线程t加塞 主线程被阻塞
            // 等到t线程结束才能继续
            // 哪个线程调用 哪个线程被加塞。并不影响其他线程
            if(i == 3){
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //todo public static native void yield();
    // 暂停当前线程，让出本次的CPU资源，加入下一次CPU资源抢夺池中
    // 下一次还有可能是本线程抢到资源

}
class thread1 extends Thread{
    public void run(){
        System.out.println("thread1");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("自定义线程被打断");
            e.printStackTrace();
        }
        //todo 当线程睡眠结束或者睡眠被中断，会执行下面这一句
        System.out.println("sleep over");
    }
}
class run1 implements Runnable{
    public void run(){
        for (int i = 10; i >= 1 ; i--) {
            // 每隔十秒打印一次
            System.out.println("run" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
