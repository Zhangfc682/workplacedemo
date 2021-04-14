package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-04 15:54
 * @Modified By:
 */

import java.util.concurrent.*;

/**
 * @ClassName: day17_02
 * @Description
 * 1.说明线程的生命周期，以及各状态切换使用到的方法。
 * 建立：创建一个新线程。
 * 就绪：调用start方法，启动线程。
 * 运行：被CPU选中，线程运行中。调用sleep、join、wait进入阻塞状态。失去CPU资源或yield(不会释放锁)方法，回到就绪状态。
 * 阻塞：线程阻塞，让出CPU资源。调用sleep，wait，join，阻塞之后，调用notify恢复为就绪状态。
 * 消亡：线程消失，释放资源，运行完毕，且不可以重新就绪。调用stop。
 *
 *
 * 2.同步代码块中涉及到同步监视器和共享数据，谈谈对同步监视器和共享数据的理解。
 * 同步监视器：任何类的对象都可以做同步监视器，相当于同步锁，线程运行过程中拿到同步锁，运行结束或阻塞时释放同步锁。
 * 共享数据：多个线程共同操作的数据，同步代码块中{}的数据。
 *
 * 解决线程安全的三种方式：
 * 同步代码块、同步方法、ReentrantLock锁。
 * synchronized同步机制在执行完代码后自动释放同步监视器；
 * Lock需要手动启动lock()方法，结束时启动unlock()方法。
 *
 *
 * 3.sleep()和wait()的区别
 * sleep：线程进入休眠状态，依然持有CPU资源和同步锁。用在Thread中；时间结束即结束休眠。
 * wait：线程等待，进入阻塞状态，且释放CPU资源和同步锁。用在同步代码中，其他进程notify才能结束。
 *
 * 4.写一个线程安全的懒汉式。
 *
 * 5.创建多线程有哪几种方式。
 * 继承Thread，实现Runnable，实现Callable，线程池。
 *
 * 线程通信：必须在同步方法中调用，调用者为同步监视器。
 * wait：当前线程进入阻塞状态，且释放同步监视器。
 * notify：唤醒一个wait的线程。
 * notifyAll：唤醒所有被wait的线程。
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/4 15:54
 * @Version: 1.0
 */
public class day17_02 {
    public static void main(String[] args){
//        lanhan_s s = lanhan_s.getInstance();
//        System.out.println(s.toString());
        myThread t = new myThread();
        FutureTask f = new FutureTask(t);
        new Thread(f).start();
        try {
            Object sum = f.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new numberThread());
        service.shutdown();
    }
}
class lanhan_s{
    //线程安全的懒汉式单例模式
    private lanhan_s(){
    }
    private static lanhan_s instance = null;

    public static lanhan_s getInstance() {
        if (instance == null){
            synchronized (lanhan_s.class){
                if (instance == null){
                    instance = new lanhan_s();
                }
            }
        }
        return instance;
    }
}
class myThread implements Callable{
    //Callable可以返回值，可以抛出异常，支持泛型。
    int sum = 0;

    @Override
    public Object call() throws Exception {
        //实现Callable接口建立线程
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            sum = sum + i;
        }
        return sum;
    }
}
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