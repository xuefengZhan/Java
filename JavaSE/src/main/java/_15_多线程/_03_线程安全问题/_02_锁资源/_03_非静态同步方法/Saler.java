package _15_多线程._03_线程安全问题._02_锁资源._03_非静态同步方法;

public class Saler extends Thread{
    private TicketService ts;

    public Saler(TicketService ts) {
        super();
        this.ts = ts;
    }
    public void run(){
        while(ts.hasTicket()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                String buy = ts.buy();
                System.out.println(this.getName() + "购买票：" + buy);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("没有票了");
    }
}
