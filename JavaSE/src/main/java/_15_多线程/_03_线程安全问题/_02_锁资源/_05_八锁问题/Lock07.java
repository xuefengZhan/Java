package _15_多线程._03_线程安全问题._02_锁资源._05_八锁问题;

class Phone07 {
    public static synchronized void sendEmail() {
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

public class Lock07 {
    public static void main(String[] args) throws InterruptedException {
        Phone07 phone = new Phone07();
        new Thread(() -> phone.sendEmail(), "A").start();
        Thread.sleep(200);
        new Thread(() -> phone.sendSms(), "B").start();
    }
}
//1个静态同步方法，1个普通同步方法，1部手机，先打印邮件还是短信？

//锁不同
//send sms
//send email
