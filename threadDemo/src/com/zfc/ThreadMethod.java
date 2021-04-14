package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 08:28
 * @Modified By:
 */

/**
 * @ClassName: ThreadMethod
 * @Description 测试Thread类中的方法
 *                 currentThread().yield(): 释放当前CPU资源，重新分配使用权。
 *                 join():在线程 a 中调用线程 b 的join方法，此时线程a进入阻塞状态，直到线程b执行完成，线程a才结束阻塞状态。
 *                 stop():强制结束线程。（已过时）
 *                 sleep():线程进入休眠状态。
 *                 isAlive():判断当前执行是否存活。
 *              线程优先级代表一个CPU选择的概率，不代表高优先级一定会优先执行，低优先级一定会最后执行。
 * @Author: Zhangfucai
 * @Date: 2021/4/1 8:28
 * @Version: 1.0
 */
public class ThreadMethod {
    public static void main(String[] args){
        HelloThread h1 = new HelloThread("helloThread");
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i + " - " + Thread.currentThread().getPriority());
            }
//            if (i == 30){
//                try {
//                    h1.join();  //主线程阻塞，线程h1结束后，a才继续开始
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        System.out.println(h1.isAlive());
    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
//                try {
//                    sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ": " + i + " - " + getPriority());
            }
//            if (i %10 == 0){
//                yield();
//            }
        }
    }

    public HelloThread(String name){
        super(name);
    }
}