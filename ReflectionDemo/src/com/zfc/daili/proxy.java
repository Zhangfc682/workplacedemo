package com.zfc.daili;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 16:22
 * @Modified By:
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: proxy
 * @Description
 * 动态代理：代理类为动态的，接口和被代理类保持不变
 * 要想实现动态代理，需要解决的问题：
 * 1.如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
 * 2.当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法。
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/12 16:22
 * @Version: 1.0
 */
public class proxy {
    public static void main(String[] args){
//        Human human = new proxyHuman(new SuperMan());
//        System.out.println(human.getBelief());
//        human.eat("apple");

        //动态代理
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);  //代理类对象

        proxyInstance.eat("香蕉");  //使用代理类调用被代理对象的方法
        System.out.println(proxyInstance.getBelief());

        LiNingCloth liNingCloth = new LiNingCloth();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory.getProxyInstance(liNingCloth);
        proxyInstance1.produceCloth();
    }
}

interface Human{
    String getBelief();
    void eat(String food);
}

class HumanUtils{
    public void method1(){
        System.out.println("==========通用方法一=========");
    }
    public void method2(){
        System.out.println("==========通用方法二=========");
    }
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe myself.";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

//动态代理
class ProxyFactory{
    //调用此方法，返回一个代理类的对象，解决问题一。
    public static Object getProxyInstance(Object obj){ //obj：被代理类对象，使用反射机制，可以获取该运行时类的对象
        MyInvocationHandlder handler = new MyInvocationHandlder();
        handler.bind(obj);

        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
        return o;
    }
}

class MyInvocationHandlder implements InvocationHandler{

    private Object obj; //需要使用被代理类的对象进行赋值
    public void bind(Object obj){
        this.obj = obj;
    }

    //当通过代理类的对象，调用方法a时，就会自动调用如下的invoke方法。
    //将被代理类要执行的方法a功能声明在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //AOP：Aspect Orient Program 面向切面编程
        HumanUtils utils = new HumanUtils();

        utils.method1();
        //method：即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        Object returnValue = method.invoke(obj, args);

        utils.method2();

        return returnValue;
    }
}

//静态代理
class proxyHuman implements Human{

    Human human;
    public proxyHuman(Human human){
        this.human = human;
    }

    @Override
    public String getBelief() {
        return "我是代理类，" + human.getBelief() + ", 代理完成";
    }

    @Override
    public void eat(String food) {
        System.out.println("我是代理类准备工作");
        human.eat(food);
        System.out.println("代理类的结束工作");
    }
}