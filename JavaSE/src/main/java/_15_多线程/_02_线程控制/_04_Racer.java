package _15_多线程._02_线程控制;

public class _04_Racer extends Thread {
    private String name;//运动员名字
    private long runTime;//每米需要时间，单位毫秒
    private long restTime;//每10米的休息时间，单位毫秒
    private long distance;//全程距离，单位米
    private long time;//跑完全程的总时间

    public _04_Racer(String name, long distance, long runTime, long restTime) {
        super();
        this.name = name;
        this.distance = distance;
        this.runTime = runTime;
        this.restTime = restTime;
    }

    @Override
    public void run() {
        long sum = 0;
        long start = System.currentTimeMillis();
        while (sum < distance) {
            System.out.println(name + "正在跑...");
            try {
                Thread.sleep(runTime);// 每米距离，该运动员需要的时间
            } catch (InterruptedException e) {
                return ;
            }
            sum++;
            try {
                if (sum % 10 == 0 && sum < distance) {
                    // 每10米休息一下
                    System.out.println(name+"已经跑了"+sum+"米正在休息....");
                    Thread.sleep(restTime);
                }
            } catch (InterruptedException e) {
                return ;
            }
        }
        long end = System.currentTimeMillis();
        time = end - start;
        System.out.println(name+"跑了"+sum+"米，已到达终点，共用时"+time/1000.0+"秒");
    }

    public long getTime() {
        return time;
    }

}
class demo{
    public static void main(String[] args) {
        _04_Racer rabbit = new _04_Racer("兔子", 30, 100, 10000);
        _04_Racer turtoise = new _04_Racer("乌龟", 30, 1000, 1000);

        rabbit.start();
        turtoise.start();

        try {
            rabbit.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            turtoise.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //因为要兔子和乌龟都跑完，才能公布结果
        System.out.println("比赛结束");
        System.out.println(rabbit.getTime()<turtoise.getTime()?"兔子赢":"乌龟赢");
    }
}