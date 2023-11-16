package _15_多线程._03_线程安全问题._02_锁资源._05_八锁问题;

class Phone03 {
    public synchronized void sendEmail() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send email");
    }
    public void hello() {
        System.out.println("hello");
    }
}
public class Lock03 {
    public static void main(String[] args) throws InterruptedException {
        Phone03 phone = new Phone03();
        new Thread(() -> phone.sendEmail(), "A").start();
        Thread.sleep(200);
        new Thread(() -> phone.hello(), "B").start();
    }
}
//hello() 方法并不是同步方法，因此不受锁的影响。
//200ms后  hello
//4000ms 后 send email