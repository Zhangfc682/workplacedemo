package com.zfc.threadSafeDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 16:34
 * @Modified By:
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LockTest
 * @Description 解决线程安全问题，使用Lock锁
 * @Author: Zhangfucai
 * @Date: 2021/4/1 16:34
 * @Version: 1.0
 */
public class LockTest {
    public static void main(String[] args){
        win w = new win();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class win implements Runnable{
    private int ticket = 100;

    //使用Lock锁方式解决线程安全问题
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                lock.lock();  //上锁

                if (ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "卖票，票号：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }finally {
                lock.unlock();  //解锁
            }
        }
    }
}