package _15_多线程._09_homework;
//案例：创建和启动2个子线程，一个打印1-40之间奇数，一个打印1-40之间偶数，
//
//（1）要求每个线程要么不打印，要么就连续打印5个数，每个数打印间隔500毫秒
//
//（2）但两个线程不要求交替打印。
public class _02_ {
    public static void main(String[] args) {
        ji ji = new ji("ji");
        ou ou = new ou("ou");

        ji.start();
        ou.start();
    }
}

class ji extends Thread{
    private int num = 1;

    public ji(String name){
        super(name);
    }
    @Override
    public void run() {
        while(num <= 40){
            synchronized (Thread.class){
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + "第"+i+"个: " + num);
                    num+=2;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}

class ou extends Thread{
    private int num = 0;

    public ou(String name){
        super(name);
    }

    @Override
    public void run() {
        while(num < 40){
            synchronized (Thread.class){
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName()+  "第"+i+"个: "+ num);
                    num+=2;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
