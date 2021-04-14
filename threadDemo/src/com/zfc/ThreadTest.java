package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-03-31 17:02
 * @Modified By:
 */

/**
 * @ClassName: ThreadTest
 * @Description 线程测试：线程执行进程的一个特定的功能，但是当不同的线程执行时需要公共的资源时，就会涉及安全问题，所以需要
 *              保证多线程的数据安全问题。
 * @Author: Zhangfucai
 * @Date: 2021/3/31 17:02
 * @Version: 1.0
 */

class MyThread extends Thread{
    @Override
    public void run() {
        //该线程主要的功能
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(i + Thread.currentThread().getName());
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args){
        //主线程main创建自定义线程对象
        MyThread t1 = new MyThread();
        t1.start();  //自定义线程开始执行自己的功能

        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(i + Thread.currentThread().getName());
            }
        }

        System.out.println("hello");
    }
}
