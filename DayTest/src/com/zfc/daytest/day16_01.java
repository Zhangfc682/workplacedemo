package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-04 12:34
 * @Modified By:
 */

import org.junit.Test;

/**
 * @ClassName: day16_01
 * @Description
 * 1.谈谈你对程序、进程、线程的理解。
 * 程序是具有特定功能的一段静态代码，是一段指令集合。某种语言编写的一组指令的集合。
 * 进程是运行中的程序。加载到内存空间中。
 * 线程是进程中的一条路径，完成进程所有功能中的一段子功能。是程序内部的一条执行路径。
 *
 * 2.代码完成继承Thread的方式创建分线程，并遍历100以内的自然数。
 *
 * 3.代码完成实现Runnable接口的方法创建分线程，并遍历100以内的自然数。
 *
 * 4.对比两种创建方式。
 * 继承Thread类：属于Thread的子类，只能继承这一个父类，重写Run方法。
 * 实现Runnable接口：实现接口，依然可以继承其他的类，重写Run方法。适合多个线程共享数据的情况。
 *
 * 5.IDEA中的Project和Module
 * Project是一个工作空间，IDEA只能显示一个工作空间。工程（为顶级结构）
 * Module相当于一个项目。
 *
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/4 12:34
 * @Version: 1.0
 */
public class day16_01 {

    @Test
    public void test1(){
        Thread t1 = new threadDemo1();
        t1.start();
    }

    @Test
    public void test2(){
        threadDemo2 t2 = new threadDemo2();
        Thread th = new Thread(t2);
        th.start();
    }
}
class threadDemo1 extends Thread{
    //完成指定功能的一个线程
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}

class threadDemo2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }
}