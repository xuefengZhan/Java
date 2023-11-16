package _15_多线程._03_线程安全问题._02_锁资源._02_非静态锁资源;

public class Test {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread t1 = new Thread(t,"t1");
        Thread t2 = new Thread(t,"t2");
        Thread t3 = new Thread(t,"t3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Ticket implements Runnable{
    //一个runnable对象可以被多个Thread类使用，因此
    // runnable对象中的属性就是Thread之间所共享的
    private int total = 20;
    @Override
    public void run() {

//        while(true){
//            synchronized (this){
//                if(total > 0){
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    System.out.println(Thread.currentThread().getName()+"买了一张票");
//                    total--;
//                    System.out.println("余票：" + total);
//                }else{
//                    break;
//                }
//            }
//
//        }
        while(total > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"买了一张票");
            total--;
            System.out.println("余票：" + total);
        }

    }
}
