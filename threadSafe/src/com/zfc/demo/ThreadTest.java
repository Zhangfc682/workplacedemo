package com.zfc.demo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 16:07
 * @Modified By:
 */

/**
 * @ClassName: ThreadTest
 * @Description 线程死锁: 不同线程分别占用对方需要的资源不放弃，都在等待对方放弃自己需要的资源，形成死锁
 *              解决方法：
 *                  专门的算法、原则
 *                  尽量减少同步资源的定义
 *                  尽量避免嵌套同步
 * @Author: Zhangfucai
 * @Date: 2021/4/1 16:07
 * @Version: 1.0
 */
public class ThreadTest {
    public static void main(String[] args){

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        //新建两个匿名线程类
        new Thread(){
            @Override
            public void run() {
                //同步代码块
                synchronized (s1){
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2){
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append("c");
                    s2.append("3");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1){
                        s1.append("d");
                        s2.append("3");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
