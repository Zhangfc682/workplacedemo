package com.zfc.threadPool;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 21:29
 * @Modified By:
 */

import java.util.concurrent.*;

/**
 * @ClassName: threadPoolDemo
 * @Description 使用线程池创建线程
 *                  提高响应速度
 *                  降低资源消耗
 *                  便于线程管理
 * @Author: Zhangfucai
 * @Date: 2021/4/1 21:29
 * @Version: 1.0
 */
class numberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class numberThread1 implements Callable{

    @Override
    public Object call() throws Exception {
        Integer sum = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
                sum += i;
            }
        }
        return sum;
    }
}

public class threadPoolDemo {
    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(10);  //创建线程池
        service.execute(new numberThread());

        FutureTask futureTask = (FutureTask) service.submit(new numberThread1());

        try {
            Object sum = futureTask.get();
            System.out.println((Integer) sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        FutureTask futureTask = new FutureTask(new numberThread1());
//        new Thread(futureTask).start();

//        try {
//            Object sum = futureTask.get();
//            System.out.println("和为： "+ sum);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

        service.shutdown();
    }
}
