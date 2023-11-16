package _15_多线程._03_线程安全问题._02_锁资源._04_静态同步方法;

public class Test2 {
    public static void main(String[] args) {

        Ticket1 t1 = new Ticket1("t1");
        Ticket1 t2 = new Ticket1("t2");
        Ticket1 t3 = new Ticket1("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket1 extends Thread {


    public static int total = 10;

    public Ticket1(String name){
        super(name);
    }


    //todo 改进：改成静态的方法即可
    // 同步方法就要求 共享资源必须为静态的
    private static synchronized void saleOneTicket(){
        if(total > 0){
            System.out.println(Thread.currentThread().getName()+"买了一张票");
            total--;
            System.out.println("余票"+total);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

   public void run(){
        while(total>0){
            saleOneTicket();
        }
   }
}