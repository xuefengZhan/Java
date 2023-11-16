package _15_多线程._03_线程安全问题._02_锁资源._05_八锁问题;

class Phone02 {
    public synchronized void sendEmail() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send email");
    }
    public synchronized void sendSms() {
        System.out.println("send sms");
    }
}

public class Lock02 {
    public static void main(String[] args) throws InterruptedException {
        Phone02 phone = new Phone02();
        new Thread(() -> phone.sendEmail(), "A").start();
        Thread.sleep(200);
        new Thread(() -> phone.sendSms(), "B").start();
    }
}

//等待4s 然后输出 send email  send sms