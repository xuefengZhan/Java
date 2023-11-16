package _15_多线程._03_线程安全问题._01_共享资源._01_非静态共享资源;

/**
 *  服务窗口提供票   是多线程共享类  其中total属性是非静态的
 */
public class TicketService {

    public int total = 10;

    public void saleTicket(){
        total--;
    }
    public boolean hasTicket(){
        return total > 0;
    }
    public int getTotal(){
        return total;
    }
}
