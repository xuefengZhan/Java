package _15_多线程._02_线程控制;

/**
 * 编写龟兔赛跑多线程程序，设赛跑长度为30米
 * 兔子的速度是10米每秒，兔子每跑完10米休眠的时间10秒
 * 乌龟的速度是1米每秒，乌龟每跑完10米的休眠时间是1秒
 * 要求：要等兔子和乌龟的线程结束，主线程（裁判）才能公布最后的结果。
 */
public class _04_Demo01 {
    public static void main(String[] args) throws InterruptedException {
        Animal rabbit = new Animal("兔子", 30, 10, 10);
        Animal gui = new Animal("乌龟", 30, 1, 1);

        rabbit.start();
        gui.start();

        rabbit.join();
        gui.join();

        System.out.println("比赛结束");
    }

}

class Animal extends Thread{

    private int distance;
    private int speed;
    private int relax;



    public Animal(String name,int distance,int speed,int relax) {
        super(name);
        this.distance = distance;
        this.speed = speed;
        this.relax = relax;
    }

    @Override
    public void run() {

        int already = 0;
        while(distance > 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            already += speed ;
            distance -= already;

            System.out.println(this.getName() + "已经跑了" + already + "米" );

            if(already % 10 == 0){
                try {
                    Thread.sleep(relax * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

