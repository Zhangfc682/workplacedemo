package com.zfc.java11;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-13 22:52
 * @Modified By:
 */

/**
 * @ClassName: myInterfaceImp
 * @Description TODO
 * @Author: Zhangfucai
 * @Date: 2021/4/13 22:52
 * @Version: 1.0
 */
public class myInterfaceImp implements MyInterface {
    //重写默认方法与抽象方法

    @Override
    public void methodAbstract() {
        System.out.println("我是实现类中完成的抽象方法");
    }

    @Override
    public void methodDefault() {
        System.out.println("我是实现类中完成的默认方法");
    }

    public static void main(String[] args){
        //接口中的静态方法只有自己可以调用
        MyInterface.methodStatic();

        //接口中的实现类对象可以调用默认方法
        new myInterfaceImp().methodDefault();

        //接口的私有方法不能在外部调用
    }

}
