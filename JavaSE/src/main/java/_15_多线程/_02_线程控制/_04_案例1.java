package _15_多线程._02_线程控制;

/**
 * 编写龟兔赛跑多线程程序，设赛跑长度为30米
 * 兔子的速度是10米每秒，兔子每跑完10米休眠的时间10秒
 * 乌龟的速度是1米每秒，乌龟每跑完10米的休眠时间是1秒
 * 要求：要等兔子和乌龟的线程结束，主线程（裁判）才能公布最后的结果。
 */
public class _04_案例1 {
    public static void main(String[] args) throws InterruptedException {
        WuGui 乌龟 = new WuGui(1, 1, "乌龟");
        TuZi 兔子 = new TuZi(10, 10, "兔子");

        乌龟.start();
        兔子.start();

        乌龟.join();
        兔子.join();

        long timeT = 兔子.getTime();
        long timeW = 乌龟.getTime();

        System.out.println("兔子" + timeT);
        System.out.println("乌龟" + timeW);

        if(timeT > timeW){
            System.out.println("乌龟赢了");
        }else{
            System.out.println("兔子赢了");
        }
    }
}

class WuGui extends Thread{
    private int way = 30;
    private int relaxWay = 10;
    private int speed;
    private int relaxTime;

    private long time;

    public  WuGui(int speed,int relaxTime,String name){
        super(name);
        this.speed = speed;
        this.relaxTime = relaxTime;

    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "起跑");
        long start = System.currentTimeMillis();
        int passedWay = 0;
        while(passedWay < way){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            passedWay += speed;

            if(passedWay % relaxWay == 0){
                try {
                    Thread.sleep(relaxTime * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        setTime( end - start);
    }

}


class TuZi extends Thread{
    private int way = 30;
    private int relaxWay = 10;
    private int speed;
    private int relaxTime;

    private long time;

    public TuZi(int speed,int relaxTime,String name){
        super(name);
        this.speed = speed;
        this.relaxTime = relaxTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "起跑");
        long start = System.currentTimeMillis();
        int passedWay = 0;
        while(passedWay < way){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            passedWay += speed;

            if(passedWay % relaxWay == 0){
                try {
                    Thread.sleep(relaxTime * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        setTime( end - start);
    }

}