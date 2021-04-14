package com.zfc.threadCommuicated;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 19:39
 * @Modified By:
 */

/**
 * @ClassName: demo1
 * @Description 线程通信：两个线程交替打印 100 以内的数字，操作同一个共享对象会出现线程安全问题
 *              只能出现在同步代码块中（synchronized）,调用者为同步监视器
 *                  wait：当前线程进入阻塞状态，并释放同步监视器
 *                  notify：唤醒一个处于 wait() 状态的线程，若存在多个线程处于wait状态，则唤醒优先级最高的一个
 *                  notifyall：唤醒所有wait()状态的线程。
 * @Author: Zhangfucai
 * @Date: 2021/4/1 19:39
 * @Version: 1.0
 */
public class demo1 {
    public static void main(String[] args){
        Number n = new Number();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}

class Number implements Runnable{

    private int number = 1;  //线程资源

    @Override
    public void run() {
        while (true){
            if (number <= 100){
                synchronized (this) {

                    //唤醒wait的线程
                    notify();

                    //操作共享资源的代码段
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;

                    try {
                        //进入wait状态，并且释放锁对象
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else {
                break;
            }
        }

    }
}