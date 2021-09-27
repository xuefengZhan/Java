package _15_多线程._02_线程控制;

public class _05_守护线程 {
    public static void main(String[] args) {
        MyDaemon m = new MyDaemon();
        m.setDaemon(true);
        m.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main:" + i);
        }
    }
}
class MyDaemon extends Thread{
    public void run(){
        while(true){
            System.out.println("MyDaemon");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}