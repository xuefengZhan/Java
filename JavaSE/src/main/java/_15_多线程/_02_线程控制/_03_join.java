package _15_多线程._02_线程控制;

import java.util.Scanner;

public class _03_join {
    public static void main(String[] args) {
        ChatThread t = new ChatThread();
        t.start();

        for (int i = 1; i < 10; i++) {
            System.out.println("main:" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //当main打印到5之后，需要等join进来的线程停止后才会继续了。
            if(i==5){
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class ChatThread extends Thread{
        public void run(){
            Scanner input = new Scanner(System.in);
            while(true){
                System.out.println("是否结束？（Y、N）");
                char confirm = input.next().charAt(0);
                if(confirm == 'Y' || confirm == 'y'){
                    break;
                }
            }
            input.close();
        }
    }
}



