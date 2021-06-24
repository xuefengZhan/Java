package _15_多线程._08_线程通信;

public class _08_多个生产者多个消费者 {


    //todo 一个生产者 对应一个消费者
    public static void main(String[] args) {
        WorkSpace1 workSpace = new WorkSpace1();

        Cook1 cook1 = new Cook1(workSpace,"cook1");
        Cook1 cook2 = new Cook1(workSpace,"cook2");
        Cook1 cook3 = new Cook1(workSpace,"cook3");
        Waiter1 waiter1 = new Waiter1(workSpace,"waiter1");
        Waiter1 waiter2 = new Waiter1(workSpace,"waiter2");
        Waiter1 waiter3 = new Waiter1(workSpace,"waiter3");

        cook1.start();
        cook2.start();
        cook3.start();

        waiter1.start();
        waiter2.start();
        waiter3.start();

        //cook1做了1道菜菜数1
        //cook1做了1道菜菜数2
        //waiter3拿走1道菜菜数1
        //waiter3拿走1道菜菜数0
        //cook3做了1道菜菜数1
        //cook3做了1道菜菜数2
        //waiter2拿走1道菜菜数1
        //waiter2拿走1道菜菜数0
        //waiter3拿走1道菜菜数-1

        //todo 执行结果有异常的
        // 因为notify会唤醒一个随机的等待队列中的线程
        // 那么消费者可能唤醒的也是消费者，那就会导致count超过正常范围

        //todo 解决方案：
        // (1) 生产者只能唤醒消费者  消费者只能唤醒生产者  SE阶段的无法实现
        // (2) 被notify唤醒后，应该重新判断条件，而不是直接执行wait后面的代码 => 循环
        //     于是将put和take()中的wait()放进循环中

        // todo 当生产者和消费者超过1个了之后
        //  要用notifyall()，无论消费者还是生产者都给唤醒
        //  如果只有notify() 也有可能陷入阻塞

    }

}

class WorkSpace1{
    private final int maxSpace = 2;

    private int count;

    public synchronized void put(){
        //如果count满了，当前线程就释放锁资源
        while(count >= maxSpace){
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
        System.out.println(Thread.currentThread().getName() + "做了1道菜" + "菜数" + count);

        //todo 唤醒对方，不管对方在不在等待队列中
        this.notify();
    }

    public synchronized  void take(){
        while(count<=0){
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
        System.out.println(Thread.currentThread().getName()+"拿走1道菜" + "菜数" + count);
        //todo 唤醒对方，不管对方在不在等待队列中
        this.notify();
    }
}

class Cook1 extends Thread{
    WorkSpace1 workSpace;


    public Cook1(WorkSpace1 workSpace,String name){
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

class Waiter1 extends Thread{
    WorkSpace1 workSpace;


    public Waiter1(WorkSpace1 workSpace,String name){
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
