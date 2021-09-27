package _15_多线程._06_线程安全问题;

public class TestSaler {
    public static void main(String[] args) {
        TicketService ts = new TicketService();

        //todo 注意s1和s2两个线程 共享同一个ts对象
//        Saler s1 = new Saler(ts);
//        Saler s2 = new Saler(ts);
//        s1.start();
//        s2.start();

        //todo s3和s4 两个线程对象中各自拥有两个TicketService对象，并且共享资源为total实例属性因此不算线程安全问题
        // 如果将TicketService类中的total属性改为静态的，仍然是线程安全问题的
        Saler s3 = new Saler();
        Saler s4 = new Saler();
        s3.start();
        s4.start();
    }
}