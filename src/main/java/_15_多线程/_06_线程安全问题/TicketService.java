package _15_多线程._06_线程安全问题;


public class TicketService {

    //todo 1.线程之间共享的数据为这个total，静态属性放在方法区=> 方法区数据可以共享
    //     2.即使total是非静态的，也可以被多个线程共享，但是得保证是同一个对象的 => 堆内存数据可以被共享
    public static int total = 10;

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
