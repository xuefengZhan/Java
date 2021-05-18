package _15_多线程._06_线程安全问题;

public class Saler extends Thread{
    private TicketService ts;

    public Saler(TicketService ts) {
        super();
        this.ts = ts;
    }

    public void run(){
        while(ts.hasTicket()){
            try {
                Thread.sleep(100);
//这里加入休眠时间，是强制让线程切换发生，增大问题出现的概率，好让大家看效果
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                String buy = ts.buy();
                System.out.println("购买票：" + buy);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        System.out.println("没有票了");
    }
}