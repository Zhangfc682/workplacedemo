package com.zfc.threadSafeDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 22:19
 * @Modified By:
 */

/**
 * @ClassName: lanhanshi
 * @Description 线程安全的懒汉式：只允许创建一个类对象
 * @Author: Zhangfucai
 * @Date: 2021/4/1 22:19
 * @Version: 1.0
 */
public class lanhanshi {
    public static void main(String[] args){
        lanhan instance = lanhan.getInstance();
    }
}

class lanhan {
    private lanhan(){} //构造方法为私有的

    private static lanhan instance = null;

    public static lanhan getInstance(){
        if (instance == null){
            instance = new lanhan();
        }
        return instance;
    }
}

class lanhan1 {
    private lanhan1(){}

    private static lanhan1 instance = null;

    public static lanhan1 getInstance(){
        //同步代码块，解决线程安全问题
        if (instance == null) {
            synchronized (lanhan1.class) {
                if (instance == null) {
                    instance = new lanhan1();
                }
            }
        }
        return instance;
    }
}