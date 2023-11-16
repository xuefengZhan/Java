package _15_多线程._03_线程安全问题._02_锁资源._04_静态同步方法;

public class Test {
    public static void main(String[] args) {

        Ticket t1 = new Ticket("t1");
        Ticket t2 = new Ticket("t2");
        Ticket t3 = new Ticket("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Ticket extends Thread {


    public static int total = 10;

    public Ticket(String name){
        super(name);
    }


    //todo 同步方法，非静态的同步方法的锁对象为this
    // 当前为三个线程对象，因此锁对象不是同一个
    // 因此无法解决线程安全问题
    private synchronized void saleOneTicket(){
        if(total > 0){
            System.out.println(getName()+"买了一张票");
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