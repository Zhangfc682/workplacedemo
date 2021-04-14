package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 10:10
 * @Modified By:
 */

/**
 * @ClassName: WindowTest1
 * @Description 三个线程窗口卖票，使用Runnable接口方式。
 * @Author: Zhangfucai
 * @Date: 2021/4/1 10:10
 * @Version: 1.0
 */
public class WindowTest1 {
    public static void main(String[] args){
        window1 win = new window1();  //创建一个对象，该对象实现的线程均共享一个变量ticket

        Thread t1 = new Thread(win);
        Thread t2 = new Thread(win);
        Thread t3 = new Thread(win);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class window1 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + "卖票，票号： " + ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
