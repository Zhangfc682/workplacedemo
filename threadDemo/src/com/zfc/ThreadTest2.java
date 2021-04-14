package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 09:57
 * @Modified By:
 */

/**
 * @ClassName: ThreadTest2
 * @Description 创建多线程方式：实现Runnable接口。
 * @Author: Zhangfucai
 * @Date: 2021/4/1 9:57
 * @Version: 1.0
 */
public class ThreadTest2 {
    public static void main(String[] args){
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);  //创建线程
        t1.start();

        Thread t2 = new Thread(mThread);  //创建线程
        t2.start();
    }
}

class MThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}