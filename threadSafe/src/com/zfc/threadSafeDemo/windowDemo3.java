package com.zfc.threadSafeDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 14:55
 * @Modified By:
 */

/**
 * @ClassName: windowDemo3
 * @Description 使用同步方法解决线程安全问题：
 * @Author: Zhangfucai
 * @Date: 2021/4/1 14:55
 * @Version: 1.0
 */
public class windowDemo3 {
    public static void main(String[] args){
        window3 win3 = new window3();

        Thread th1 = new Thread(win3);
        Thread th2 = new Thread(win3);
        Thread th3 = new Thread(win3);

        th1.start();
        th2.start();
        th3.start();
    }
}

class window3 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            show();
        }
    }

    public synchronized void show(){  //非静态的同步锁：this
        //处理同步数据的方法，声明为同步synchronized
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + "卖票， 票号：" + ticket);
            ticket--;
        }
    }
}
