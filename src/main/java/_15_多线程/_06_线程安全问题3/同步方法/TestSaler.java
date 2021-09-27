package _15_多线程._06_线程安全问题3.同步方法;

public class TestSaler {
    public static void main(String[] args) {
        TicketService ts = new TicketService();
        Saler s1 = new Saler(ts);
        Saler s2 = new Saler(ts);

        s1.start();
        s2.start();
    }
}