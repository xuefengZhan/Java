package _15_多线程._01_线程的创建;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class _03_FutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("futureTask");
                Thread.sleep(100);
                return 100;
            }
        });


        // 主线程阻塞，同步等待 task 执行完毕的结果
        new Thread(futureTask,"我的名字").start();
        System.out.println("main");

        System.out.println(futureTask.get());


    }
}
