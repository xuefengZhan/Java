package _15_多线程._03_线程安全问题._02_锁资源._05_八锁问题;

class Phone06 {
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

public class Lock06 {
    public static void main(String[] args) throws InterruptedException {
        Phone06 phone1 = new Phone06();
        Phone06 phone2 = new Phone06();
        new Thread(() -> phone1.sendEmail(), "A").start();
        Thread.sleep(200);
        new Thread(() -> phone2.sendSms(), "B").start();
    }
}
//2个静态同步方法，2部手机，先打印邮件还是短信？  phone06.class 是共用的

// send email
// send sms