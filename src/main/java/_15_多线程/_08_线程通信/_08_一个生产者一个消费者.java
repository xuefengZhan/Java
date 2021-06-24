package _15_多线程._08_线程通信;

public class _08_一个生产者一个消费者 {


    //todo 一个生产者 对应一个消费者
    public static void main(String[] args) {
        WorkSpace workSpace = new WorkSpace();
        Cook cook = new Cook(workSpace,"cook");
        Waiter waiter = new Waiter(workSpace,"waiter");

        cook.start();
        waiter.start();

        //执行结果：
        //cook加1
        //cook加1
        //waiter减1
        //cook加1
        //cook加1
        //waiter减1
        //cook加1     cook wait了
        //waiter减1
        //waiter减1
        //waiter减1   waiter 也 wait了
        //二者都在wait，释放不了资源
    }

}
class WorkSpace{
    private final int maxSpace = 3;

    private int count;

    public synchronized void put(){
        //如果count满了，当前线程就释放锁资源
        if(count >= maxSpace){
            try {
                wait();
                //todo wait()必须由锁对象来调用
                //1.当前wait() 等价于 this.wait() this就是workSpace对象
                //2.workSpace如何成为锁对象？ 添加同步方法或者同步代码块内
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ "加1");

        //todo 唤醒对方，不管对方在不在等待队列中
        this.notify();
    }

    public synchronized  void take(){
        if(count<=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"减1");
        //todo 唤醒对方，不管对方在不在等待队列中
        this.notify();
    }
}
class Cook extends Thread{
    WorkSpace workSpace;


    public Cook(WorkSpace workSpace,String name){
        super(name);
        this.workSpace = workSpace;
    }

    @Override
    public void run() {
        while(true){
            workSpace.put();
        }
    }
}
class Waiter extends Thread{
    WorkSpace workSpace;


    public Waiter(WorkSpace workSpace,String name){
        super(name);
        this.workSpace = workSpace;
    }

    @Override
    public void run() {
        while(true){
            workSpace.take();
        }
    }
}
