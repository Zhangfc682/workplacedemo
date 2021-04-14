package com.zfc.threadSafeDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 15:10
 * @Modified By:
 */

/**
 * @ClassName: windowDemo4
 * @Description 继承的方式实现多线程，使用同步方法解决线程安全问题。
 * @Author: Zhangfucai
 * @Date: 2021/4/1 15:10
 * @Version: 1.0
 */
public class windowDemo4 {
    public static void main(String[] args){
        window4 t1 = new window4();
        window4 t2 = new window4();
        window4 t3 = new window4();

        t1.start();
        t2.start();
        t3.start();
    }
}

class window4 extends Thread{

    private static int ticket = 100;

//    private static Object obj = new Object();  //同步锁

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

    public static synchronized void show(){  //静态方法，依赖类存在，即为window4
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票，票号：" + ticket);
            ticket--;
        }
    }
}
