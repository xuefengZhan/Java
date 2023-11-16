package _15_多线程._03_线程安全问题._01_共享资源._01_非静态共享资源;


import _15_多线程._03_线程安全问题._01_共享资源._01_非静态共享资源.TicketService;

//买票窗口类
public class Saler extends Thread{
    private TicketService ts;

    //锁对象：Thread子类的静态属性=>所有Saler对象共享的同一个对象
    private  final Object obj = new Object();


    //一个窗口对应一个
    public Saler(){
        ts = new TicketService();
    }

    //多个窗口对应一个
    public Saler(TicketService ts) {
        this.ts = ts;
    }

    //todo 1.下面的代码会引发线程安全问题：
    // 共享资源被多个线程同时访问
    public void run(){
            while(ts.hasTicket()){

                //这里加入休眠时间，是强制让线程切换发生，增大问题出现的概率，好让大家看效果
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    ts.saleTicket();
                    System.out.println(getName() + "买了一张票，余票：" + ts.getTotal());
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        System.out.println("没有票了");
    }



    //todo 2.上锁   锁的范围不能太大也不能太小，太大会导致别的线程不容易获得锁，太小无法保证线程安全
    // 下面这段代码所得范围太大，只能一个线程买票
//    public void run(){
//       synchronized (obj){
//           while(ts.hasTicket()){
//               //这里加入休眠时间，是强制让线程切换发生，增大问题出现的概率，好让大家看效果
//               try {
//                   Thread.sleep(100);
//               } catch (InterruptedException e) {
//                   e.printStackTrace();
//               }
//
//               try {
//                   ts.saleTicket();
//                   System.out.println(getName() + "买了一张票，余票：" + ts.getTotal());
//               } catch (Exception e) {
//                   System.err.println(e.getMessage());
//               }
//           }
//       }
//        System.out.println("没有票了");
//    }


    //todo 3。缩小锁的范围：
    //       任何关于公共资源的操作都要放进同步代码块中
    //       但是循环又不能放进同步代码块中，因此切换判断条件，将判断条件放进循环内部！
//    public void run(){
//
//            //while(ts.hasTicket()){
//
//            while(true){
//               synchronized (obj){
//                   if(ts.hasTicket()){
//                       //这里加入休眠时间，是强制让线程切换发生，增大问题出现的概率，好让大家看效果
//                       try {
//                           Thread.sleep(100);
//                       } catch (InterruptedException e) {
//                           e.printStackTrace();
//                       }
//
//                       try {
//                           ts.saleTicket();
//                           System.out.println(getName() + "买了一张票，余票：" + ts.getTotal());
//                       } catch (Exception e) {
//                           System.err.println(e.getMessage());
//                       }
//                   }else break;
//               }
//            }
//
//        System.out.println("没有票了");
//    }

}