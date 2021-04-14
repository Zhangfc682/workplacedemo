package com.zfc.threadSafeDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 17:02
 * @Modified By:
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: AccountTest
 * @Description 银行储蓄问题，两个人向同一个账户存钱，存三次，每次1000.
 *                  涉及线程安全问题：因为两个人操作同一个账户，包含两个线程，且同时操作数据。
 * @Author: Zhangfucai
 * @Date: 2021/4/1 17:02
 * @Version: 1.0
 */
public class AccountTest {
    public static void main(String[] args){
        account a = new account();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);

        t1.setName("第一个人");
        t2.setName("第二个人");

        t1.start();
        t2.start();
    }
}

class account implements Runnable{

    //实现线程类：线程的功能是向银行账户存钱
    private int acc = 0;
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            lock.lock();  //现在上锁，表示第一个人进来完成3次，才释放，没有体现交互

            for (int i = 0; i < 3; i++) {
                acc = acc + 1000;
                System.out.println(Thread.currentThread().getName() + "存入1000，余额为： " + acc);
            }
        }finally {
            lock.unlock();
        }
    }
}
