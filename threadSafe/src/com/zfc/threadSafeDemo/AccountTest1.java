package com.zfc.threadSafeDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 17:27
 * @Modified By:
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: AccountTest1
 * @Description 同一个账户银行存钱线程安全问题
 * @Author: Zhangfucai
 * @Date: 2021/4/1 17:27
 * @Version: 1.0
 */
public class AccountTest1 {
    public static void main(String[] args){
        Account a = new Account(0);  //共享数据的对象

        Costumer c = new Costumer(a);

        Thread p1 = new Thread(c);
        Thread p2 = new Thread(c);

        p1.setName("甲");
        p2.setName("乙");

        p1.start();
        p2.start();
    }
}

class Account{  //银行账户类
    private int money;

    public Account(int money) {
        this.money = money;
    }

//    public synchronized void addMoney(int m){  //将存钱方法设为同步
    public void addMoney(int m){  //将存钱方法设为同步
        //存钱方法
        money = money + m;
        System.out.println(Thread.currentThread().getName() + " 存钱1000成功，余额为： " + money);
    }
}

class Costumer implements Runnable{
    //用户线程，共享一个账户
    Account acc;
    ReentrantLock lock = new ReentrantLock();  //设置一个锁对象

    public Costumer(Account acc) {
        this.acc = acc;
    }

    @Override
    public void run() {
        //线程的功能为存钱3次
        for (int i = 0; i < 3; i++) {
            try {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.lock();
                //操作共享数据
                acc.addMoney(1000);
            }finally {
                lock.unlock();
            }
        }
    }
}