package _15_多线程._03_线程安全问题._02_锁资源._05_八锁问题;

class Phone08 {
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

public class Lock08 {
    public static void main(String[] args) throws InterruptedException {
        Phone08 phone1 = new Phone08();
        Phone08 phone2 = new Phone08();
        new Thread(() -> phone1.sendEmail(), "A").start();
        Thread.sleep(200);
        new Thread(() -> phone2.sendSms(), "B").start();
    }
}
//1个静态同步方法，1个普通同步方法，2部手机，先打印邮件还是短信？

// 一个是Phone08.class  一个是phone08对象 不公用

//sms
//email