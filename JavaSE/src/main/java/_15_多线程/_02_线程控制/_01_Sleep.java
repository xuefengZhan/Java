package _15_多线程._02_线程控制;

import java.util.concurrent.TimeUnit;

public class _01_Sleep {
    public static void main(String[] args) {
         new Thread(new Runnable() {
             @Override
             public void run() {
                 System.out.println("倒计时预备：");
                 for (int i = 10; i > 0 ; i--) {
                     System.out.println(i);
                     try {
                         //Thread.sleep(1000);
                         TimeUnit.SECONDS.sleep(1);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 System.out.println("新年快乐！");
             }
         }, "倒计时").start();
    }
}
