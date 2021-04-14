package com.zfc.java11;

/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-13 22:50
 * @Modified By:
 */
public interface MyInterface {

    void methodAbstract();

    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }

    default void methodDefault(){
        System.out.println("我是接口中的默认方法");
        methodPrivate();
    }

    private void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }

}
