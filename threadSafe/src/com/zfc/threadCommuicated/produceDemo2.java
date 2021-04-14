package com.zfc.threadCommuicated;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 20:39
 * @Modified By:
 */

/**
 * @ClassName: produceDemo2
 * @Description 生产者消费者demo
 * @Author: Zhangfucai
 * @Date: 2021/4/1 20:39
 * @Version: 1.0
 */
public class produceDemo2 {
    public static void main(String[] args){
        //共享的店员对象
        Cle cc = new Cle();

        Thread pro = new Thread(new prod(cc));
        Thread cos = new Thread(new cost(cc));

        pro.setName("生产者 ");
        cos.setName("消费者 ");

        pro.start();
        cos.start();
    }
}

//共享的店员类
class Cle{
    public int num;

    public Cle() {
        num = 0;
    }

    public synchronized void produce() {
        if (num < 20){
            num++;
            System.out.println(Thread.currentThread().getName() + "生产 " + num);

            //一旦生产了一件，就唤醒消费者
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void costum() {
        if (num > 0){
            System.out.println(Thread.currentThread().getName() + "消费 " + num);
            num--;

            //一旦生产了一件，就唤醒生产者
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class prod implements Runnable{
//生产者类
    Cle cle;

    public prod(Cle cle) {
        this.cle = cle;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始生产。。。");

        while (true){
            cle.produce();
        }
    }
}

class cost implements Runnable{
//消费者类
    Cle cle;

    public cost(Cle cle) {
        this.cle = cle;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始消费。。。");
        while (true){
            cle.costum();
        }
    }
}