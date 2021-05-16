package _15_多线程;

import org.junit.Test;

public class _03_ThreadAPI {


    //todo 1.public static void sleep
    @Test
    public void test01(){
        for (int i = 10; i >= 1 ; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
