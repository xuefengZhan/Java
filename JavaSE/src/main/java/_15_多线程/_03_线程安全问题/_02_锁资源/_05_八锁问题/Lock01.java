package _15_多线程._03_线程安全问题._02_锁资源._05_八锁问题;


class Phone {
    public synchronized void sendEmail() {
        System.out.println("send email");
    }
    public synchronized void sendSms() {
        System.out.println("send sms");
    }
}

public class Lock01 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(() -> phone.sendEmail(), "A").start();
        Thread.sleep(200);  //保证了线程 A 比 B 先执行
        new Thread(() -> phone.sendSms(), "B").start();
    }
}