package _15_多线程._08_线程通信.奇偶打印;

//案例：在子线程中输出1-100之间的偶数，主线程输出1-100之间的奇数。
public class _01_ {
    public static void main(String[] args) {
        new Thread("子线程") {
            public void run() {
                for (int i = 0; i < 100; i += 2) {
                    System.out.println(Thread.currentThread().getName() + i);
                }
            }
        }.start();

        for (int i = 1; i < 100; i += 2) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }
}
