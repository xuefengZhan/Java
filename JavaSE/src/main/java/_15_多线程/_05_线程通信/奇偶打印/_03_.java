package _15_多线程._05_线程通信.奇偶打印;
//在第二个基础上，实现两个线程交替打印。
public class _03_ {
    public static void main(String[] args) {
        Thread ji = new Thread(new jiOu2(1));
        Thread ou = new Thread(new jiOu2(2));
        ji.start();
        ou.start();
    }
}

class jiOu2 implements Runnable {
    int start;

    public jiOu2(int start) {
        this.start = start;
    }

    @Override
    public void run() {
        while (start <= 40) {
            synchronized ("") {
                "".notify();
                for (int i = 0; i < 5; i++) {
                    System.out.println(start);
                    start += 2;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i == 4 && (start < 41)){
                        try {
                            "".wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
    //注意：假设线程1执行到39 或者 40 的时候，线程1 就结束了； 此时线程2被nofity了
    //线程2执行完后，就wait了，因此程序最后会阻塞住！
}