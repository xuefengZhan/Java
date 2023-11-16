package _15_多线程._03_线程安全问题._02_锁资源._05_八锁问题;

class Phone04 {
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

public class Lock04 {
    public static void main(String[] args) throws InterruptedException {
        Phone04 phone1 = new Phone04();
        Phone04 phone2 = new Phone04();
        new Thread(() -> phone1.sendEmail(), "A").start();
        Thread.sleep(200);
        new Thread(() -> phone2.sendSms(), "B").start();
    }
}
//synchronized 锁的是 this，所以会产生两把锁，它们之间互不干扰，谁先执行完谁就先打印。
// 200ms后
// send sms
//4s后
//send email