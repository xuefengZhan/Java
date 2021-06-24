package _15_多线程._06_线程安全问题3;

public class Test2 {
    public static void main(String[] args) {

        Ticket t1 = new Ticket("t1");
        Ticket t2 = new Ticket("t2");
        Ticket t3 = new Ticket("t3");

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