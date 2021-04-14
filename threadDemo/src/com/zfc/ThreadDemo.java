package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 08:15
 * @Modified By:
 */

/**
 * @ClassName: ThreadDemo
 * @Description 创建两个线程，分别输出奇数和偶数
 * @Author: Zhangfucai
 * @Date: 2021/4/1 8:15
 * @Version: 1.0
 */
public class ThreadDemo {
    public static void main(String[] args){
//        MyThread1 t1 = new MyThread1();
//        MyThread2 t2 = new MyThread2();
//
//        t1.start();
//        t2.start();

        //使用匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();
    }
}

class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}
