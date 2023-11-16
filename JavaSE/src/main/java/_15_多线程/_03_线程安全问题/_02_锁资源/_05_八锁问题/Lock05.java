package _15_多线程._03_线程安全问题._02_锁资源._05_八锁问题;

class Phone05 {
    public static synchronized void sendEmail() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send email");
    }

    public static synchronized void sendSms() {
        System.out.println("send sms");
    }
}

public class Lock05 {
    public static void main(String[] args) throws InterruptedException {
        Phone05 phone = new Phone05();
        new Thread(() -> phone.sendEmail(), "A").start();
        Thread.sleep(200);
        new Thread(() -> phone.sendSms(), "B").start();
    }
}
// 2个静态同步方法，1部手机，先打印邮件还是短信？
// 静态同步方法的锁是  Phone05.class 是公用的

//send email
//send Sms