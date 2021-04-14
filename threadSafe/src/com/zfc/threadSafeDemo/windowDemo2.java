package com.zfc.threadSafeDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 14:32
 * @Modified By:
 */

/**
 * @ClassName: windowDemo2
 * @Description 使用继承的方式创建线程，解决线程安全问题。
 *                  使用同步代码块解决。
 * @Author: Zhangfucai
 * @Date: 2021/4/1 14:32
 * @Version: 1.0
 */
public class windowDemo2 {
    public static void main(String[] args){
        window2 t1 = new window2();
        window2 t2 = new window2();
        window2 t3 = new window2();

        t1.start();
        t2.start();
        t3.start();
    }
}

class window2 extends Thread{

    private static int ticket = 100;

    private static Object obj = new Object();  //同步锁

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            synchronized (obj) {
            synchronized (window2.class) {  //使用自己的类对象作为锁，自己的类对象只会加载一次
                if (ticket > 0) {
                    System.out.println(getName() + "卖票，票号：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}