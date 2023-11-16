package _15_多线程._05_线程通信.奇偶打印;

public class Solution {
    public static void main(String[] args) {
        printer printer = new printer();

        Thread t1 = new Thread(printer,"t1");
        Thread t2 = new Thread(printer,"t2");

        t1.start();
        t2.start();
    }
}

class printer implements Runnable{

    int num = 1;

    @Override
    public void run() {
        try {
            printNum();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    private synchronized void printNum() throws InterruptedException {
        while(num <= 100){
            notify();
            System.out.println(Thread.currentThread().getName() + " print : " + num++);
            wait();
        }
        notify();
    }
}
