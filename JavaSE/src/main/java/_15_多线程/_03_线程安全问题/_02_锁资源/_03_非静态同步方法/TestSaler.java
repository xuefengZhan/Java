package _15_多线程._03_线程安全问题._02_锁资源._03_非静态同步方法;

public class TestSaler {
    public static void main(String[] args) {
        TicketService ts = new TicketService();
        Saler s1 = new Saler(ts);
        Saler s2 = new Saler(ts);

        s1.start();
        s2.start();
    }
}