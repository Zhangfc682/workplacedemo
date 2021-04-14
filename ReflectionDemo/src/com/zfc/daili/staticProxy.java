package com.zfc.daili;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 16:00
 * @Modified By:
 */

/**
 * @ClassName: staticProxy
 * @Description
 * 静态代理：特点是，代理类和被代理类在编译期间，就确定下来了。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/12 16:00
 * @Version: 1.0
 */
public class staticProxy {
    public static void main(String[] args){
        ClothFactory lining = new LiNingCloth();
        ClothFactory proxyCloth = new proxyClothFactory(lining);

        proxyCloth.produceCloth();
    }
}

interface ClothFactory{
    void produceCloth();
}

//代理类
class proxyClothFactory implements ClothFactory{

    private ClothFactory factory; // 使用被代理类对象作为参数，进行实例化
    public proxyClothFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        //代理类完成衣服工厂时，为被代理类完成准备工作和后续工作，实际的生产衣服操作依然是被代理对象完成
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续工作");
    }
}

//被代理类
class LiNingCloth implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Li-Ning工厂生产衣服");
    }
}