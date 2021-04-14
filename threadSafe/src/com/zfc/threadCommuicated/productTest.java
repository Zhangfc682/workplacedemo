package com.zfc.threadCommuicated;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 20:03
 * @Modified By:
 */

/**
 * @ClassName: productTest
 * @Description 生产者消费者问题
 * @Author: Zhangfucai
 * @Date: 2021/4/1 20:03
 * @Version: 1.0
 */
public class productTest {
    public static void main(String[] args){
        Clerk c = new Clerk();

        Producer p1 = new Producer(c);  //使用共享资源c新建两个线程
        Costumer c1 = new Costumer(c);

        p1.setName("生产者 ");
        c1.setName("消费者 ");

        p1.start();
        c1.start();
    }
}

class Clerk{
    //生产者于消费者共享的店员
    int count = 0;

    public synchronized void produceProduct() {  //需要操作共享资源count，所以加synchronized
        if (count < 20){
            count++;
            System.out.println(Thread.currentThread().getName() + " 生产第 " + count + "产品");

            //只要生产了一个，就可以激活wait状态的消费者
            notify();
        }else {
            //产品比20多，则停止生产，开始等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void costumProduct() {
        if (count > 0){
            System.out.println(Thread.currentThread().getName() + " 消费第 " + count + "产品");
            count--;

            //只要消费了一个，就可以唤醒wait状态的生产者
            notify();
        }else {
            //产品数量比0小，停止消费，开始等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{  //生产者线程类 生产商品
    Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产。。。");

        while (true) {
            clerk.produceProduct();
        }
    }
}

class Costumer extends Thread{
    //消费者线程
    Clerk clerk;

    public Costumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费。。。");
        while (true) {
            clerk.costumProduct();
        }
    }
}