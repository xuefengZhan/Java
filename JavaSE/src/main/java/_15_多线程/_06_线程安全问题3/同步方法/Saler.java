package _15_多线程._06_线程安全问题3.同步方法;

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
