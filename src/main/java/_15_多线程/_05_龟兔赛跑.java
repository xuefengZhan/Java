package _15_多线程;

import org.junit.Test;

public class _05_龟兔赛跑 {
    //todo 跑道长30米
    // 兔子：10m/s  跑完10m 休眠10s
    // 乌龟：1m/s   跑完10m 休眠1s
    // 要求：每跑完1m，显示：xxx跑了几米
    //      休息时，显示：xxx在休息


//    public static void main(String[] args){
//        Tuzi t = new Tuzi();
//        WuGui w = new WuGui();
//        t.start();
//        w.start();
//    }

//    public static void main(String[] args){
//        SportMan 兔子 = new SportMan("兔子", 100, 10000, 30);
//        SportMan 乌龟 = new SportMan("乌龟", 1000, 1000, 30);
//
//        兔子.start();
//        乌龟.start();
//    }


//    public static void main(String[] args){
//        SportMan2 兔子 = new SportMan2("兔子", 100, 10000, 30);
//        SportMan2 乌龟 = new SportMan2("乌龟", 1000, 1000, 30);
//
//        兔子.start();
//        乌龟.start();
//
//
//        try {
//            兔子.join();
//            乌龟.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        //下面这段代码需要等到兔子和乌龟两个线程执行完之后才执行
//        // 因此要用兔子和乌龟线程进行加塞
//        long diff = 兔子.getTotalTime()-乌龟.getTotalTime();
//        if(diff < 0){
//            System.out.println("兔子赢了");
//        }else if(diff > 0){
//            System.out.println("乌龟赢了");
//        }else{
//            System.out.println("平局");
//        }
//    }


    public static void main(String[] args) {

        //todo step1. 启动两个线程
        SportMan3 兔子 = new SportMan3("兔子", 100, 10000, 30);
        SportMan3 乌龟 = new SportMan3("乌龟", 1000, 1000, 30);

        兔子.start();
        乌龟.start();

        //todo step2.有一方结束 停止线程  结束比赛
        while(true){
            if(兔子.isOver() || 乌龟.isOver()){
                兔子.interrupt();
                乌龟.interrupt();

                兔子.stop();
                乌龟.stop();

//                兔子.setStop();
//                乌龟.setStop();

                break;
            }
        }

        //todo step3. 宣布结果
        if(兔子.isOver() && 乌龟.isOver()){
            System.out.println("平");
        }else if(兔子.isOver()){
            System.out.println("兔子win");
        }else{
            System.out.println("乌龟win");
        }
    }


    // todo 现象：
    //  step3一直未执行 （主线程每走，while(true)没出来）
    //  兔子和乌龟都跑完全程了

    //todo  volatile 的作用：
    // 原因：while(true)中频繁调用isOver()查看对象的属性值
    //      jvm进行了优化，发现属性值一直不变，于是将此属性值从堆中拿到了main线程的“缓存”中了
    //      因此会导致堆内存中属性值改变了，但是main线程的缓存值还是没有改变
    // 解决方法：
    //      将over变量设置为volatile
    // 意思是：去读取主存中的值，不要读本地缓存了

    //todo stop()
    // 即使添加了volatile之后，执行的现象还是没变：
    // 兔子和乌龟都跑完了全程 并且  仍然退不出while(true)循环
    // 这说明当兔子或者乌龟达到了终点并没有让线程结束，否则另一个也不会跑完全程
    // 解决方法：
    //  线程的结束：结束循环即可。  用变量的值决定是否结束循环 而非用stop()来结束



}

class Tuzi extends Thread {


    public void run(){
        for (int i = 0; i <= 30 ; i+=10) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("兔子跑了"+ i + "米");
            if(i%10 == 0 && i < 30){
                System.out.println("兔子在休息");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
class WuGui extends Thread{
    public void run(){
        for (int i = 0; i <= 30 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("乌龟跑了"+ i + "米");
            if(i%10 == 0 && i < 30){
                System.out.println("乌龟在休息");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

class SportMan extends Thread{
    private String name;
    private long millsPerMeter;//每米的时间
    private long restPerTenMeter;//每10s休息时间
    private int distance;

    public SportMan(String name,long millsPerMeter,long restPerTenMeter,int distance){
        this.name = name;
        this.millsPerMeter = millsPerMeter;
        this.restPerTenMeter = restPerTenMeter;
        this.distance = distance;
    }


    public void run(){

        for (int i = 0; i <= distance ; i++) {

            //每隔1米 打印一次 跑了多少米
            try {
                Thread.sleep(millsPerMeter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +"跑了"+ i + "米");

            //每隔10米休息一次
            if(i>0 && i % 10 == 0 && i < distance){
                System.out.println(name + "在休息");
                try {
                    Thread.sleep(restPerTenMeter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

// 要求：能够获取一个运动员跑完全程的时间
// 主线程中能够比较两个运动员谁先跑完
class SportMan2 extends Thread{
    private String name;
    private long millsPerMeter;
    private long restPerTenMeter;
    private int distance;
    //todo 用一个属性保存
    private long TotalTime;

    public long getTotalTime(){
        return TotalTime;
    }

    public SportMan2(String name,long millsPerMeter,long restPerTenMeter,int distance){
        this.name = name;
        this.millsPerMeter = millsPerMeter;
        this.restPerTenMeter = restPerTenMeter;
        this.distance = distance;
    }

    public void run(){
        long start = System.currentTimeMillis();
        for (int i = 0; i <= distance ; i++) {

            //每隔1米 打印一次 跑了多少米
            try {
                Thread.sleep(millsPerMeter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +"跑了"+ i + "米");

            //每隔10米休息一次
            if(i>0 && i % 10 == 0 && i < distance){
                System.out.println(name + "在休息");
                try {
                    Thread.sleep(restPerTenMeter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        TotalTime = end - start;

    }
}
// 要求：只要有一个运动员跑完了，比赛就结束了
// 先跑完的赢了，其他运动员就停下来，不要再跑了。
// 重点： volatile的作用 和  如何让线程停下来
class SportMan3 extends Thread{
    private String name;
    private long millsPerMeter;
    private long restPerTenMeter;
    private int distance;
    private long TotalTime;

    //todo 是否跑完了
    private volatile boolean over = false;

    //todo 是否要停止当前线程
    private boolean stop;
    public void setStop(){
        stop = true;
    }

    public boolean isOver() {
        return over;
    }

    public long getTotalTime(){
        return TotalTime;
    }

    public SportMan3(String name,long millsPerMeter,long restPerTenMeter,int distance){
        this.name = name;
        this.millsPerMeter = millsPerMeter;
        this.restPerTenMeter = restPerTenMeter;
        this.distance = distance;
    }

    public void run(){
        long start = System.currentTimeMillis();
        int i = 0;
        for (; i <= distance && stop != true ; i++) {

            //每隔1米 打印一次 跑了多少米
            try {
                Thread.sleep(millsPerMeter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name +"跑了"+ i + "米");

            //每隔10米休息一次
            if(i>0 && i % 10 == 0 && i < distance){
                System.out.println(name + "在休息");
                try {
                    Thread.sleep(restPerTenMeter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        //只有跑完了全程的才会设置为true,如果没跑完比赛就结束了，不算跑完
        //跑完了执行到这一步，i=31
        if(i >= distance){
            over = true;
        }
        System.out.println("========" + name + "跑完了========");
        long end = System.currentTimeMillis();
        TotalTime = end - start;

    }
}