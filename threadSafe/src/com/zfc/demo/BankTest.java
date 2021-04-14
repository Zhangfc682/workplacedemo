package com.zfc.demo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 15:47
 * @Modified By:
 */

/**
 * @ClassName: BankTest
 * @Description 解决单例模式中的线程安全。
 * @Author: Zhangfucai
 * @Date: 2021/4/1 15:47
 * @Version: 1.0
 */
public class BankTest {
    public static void main(String[] args){

    }
}

class Bank{
    //私有的构造方法
    private Bank(){}

    //私有的实例属性
    private static Bank instance = null;

    public static Bank getInstance(){

        //同步代码块
//        synchronized (Bank.class) {  // 方法一：效率差，所有进来的线程都需要判断是否有实例对象
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }

        //方法二
        if (instance == null){
            synchronized (Bank.class){
                if (instance == null){
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}