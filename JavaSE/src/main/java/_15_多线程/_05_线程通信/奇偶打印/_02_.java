package _15_多线程._05_线程通信.奇偶打印;

//案例：创建和启动2个子线程，一个打印1-40之间奇数，一个打印1-40之间偶数，
//
//（1）要求每个线程要么不打印，要么就连续打印5个数，每个数打印间隔500毫秒
//
//（2）但两个线程不要求交替打印。
public class _02_ {
    public static void main(String[] args) {
        Thread ji = new Thread(new jiOu(1));
        Thread ou = new Thread(new jiOu(2));
        ji.start();
        ou.start();
    }
}

class jiOu implements Runnable {
    int start;

    public jiOu(int start) {
        this.start = start;
    }

    @Override
    public void run() {
        while (start <= 40) {
            synchronized ("") {
                for (int i = 0; i < 5; i++) {
                    System.out.println(start);
                    start += 2;
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