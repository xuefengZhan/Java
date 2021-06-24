package _15_多线程._09_homework;


//（2）在第二个基础上，实现两个线程交替打印。
public class _03_ {
    public static void main(String[] args) {
        ji2 ji = new ji2("ji");
        ou2 ou = new ou2("ou");

        ji.start();
        ou.start();
    }
}

class ji2 extends Thread{
    private int num = 1;

    public ji2(String name){
        super(name);
    }
    @Override
    public void run() {
        while(num <= 40){
            synchronized (Thread.class){
                Thread.class.notify();


                for ( int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "第"+i+"个: " + num);
                    num+=2;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(i==4 && num != 41){
                        try {
                            Thread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }

}

class ou2 extends Thread{
    private int num = 0;

    public ou2(String name){
        super(name);
    }

    @Override
    public void run() {
        while(num < 40){
            synchronized (Thread.class){
                Thread.class.notify();

                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+  "第"+i+"个: "+ num);
                    num+=2;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if(i==4 && num != 40){
                        try {
                            Thread.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        }
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }
}
