package com.zfc.threadSafeDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 14:06
 * @Modified By:
 */

/**
 * @ClassName: windowDemo
 * @Description 使用同步机制解决线程安全问题：操作同步代码时，只能有一个线程参与，其他线程等待，相当于单线程的过程，效率低。
 *                  1.同步代码块：
 *                      synchronized(同步监视器){
 *                          需要被同步的代码（操作共享数据的代码，多个线程共同操作的变量）
 *                      }
 *                      同步监视器：俗称锁。任何一个类的对象都可以充当锁。
 *
 *                  2.同步方法：
 *                      如果操作共享数据的代码完整的声明在一个方法中，可以将该方法声明为同步的。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/1 14:06
 * @Version: 1.0
 */
public class windowDemo {
    public static void main(String[] args){
        window win = new window();

        Thread t1 = new Thread(win);
        Thread t2 = new Thread(win);
        Thread t3 = new Thread(win);

        t1.start();
        t2.start();
        t3.start();
    }
}

class window implements Runnable{

    private int ticket = 100;
//    Object obj = new Object(); // 任何类的对象都可以充当同步监视器（锁），多个线程共用同一把锁。

    @Override
    public void run() {
        while (true){
//            synchronized(obj) {
            synchronized(this) {  //也可以使用当前对象充当锁
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);  //即使当前线程阻塞，也不会打开锁，直到该线程执行完毕，才会打开同步锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "卖票， 票号： " + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
