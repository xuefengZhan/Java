package _15_多线程._06_线程安全问题4;

public class Test {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread t1 = new Thread(t,"t1");
        Thread t2 = new Thread(t,"t2");
        Thread t3 = new Thread(t,"t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket implements Runnable{

    private int total = 10;
    @Override
    public void run() {

        while(total>0){
           saleOneTicket();
        }
    }

    //todo 比较与线程安全3用同步代码块解决线程问题
    // 这里不需要用静态同步方法，因为runnable对象是多个线程公用的，
    // 非静态同步方法的锁对象就是this
    public synchronized void saleOneTicket(){
        if(total > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"买了一张票");
            total--;
            System.out.println("余票：" + total);
        }
    }
}
