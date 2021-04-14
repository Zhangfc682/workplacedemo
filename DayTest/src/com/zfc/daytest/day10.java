package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-03 13:57
 * @Modified By:
 */

/**
 * @ClassName: day10
 * @Description
 * 1.构造器的作用是什么？使用中有哪些注意点。
 * 初始化对象的结构；创建对象。
 * 类一定会有构造器。
 *
 * 2.关于类的属性的赋值，有几种赋值方式。谈谈赋值的先后顺序。
 * 默认初始化；显式初始化；构造器中初始化；对象.方法；对象.属性
 * 初始化赋值
 * 对象.属性
 * set方法
 *
 * 3.this关键字可以用来调用哪些结构，简单说明一下其使用。
 * 调用当前对象的属性和方法，构造器。
 *
 * 4.Java中涉及到的四种权限修饰符，说明各自的权限范围。
 * public: 类内，同一个包下，不同包的子类，同一个工程；
 * protected: 类内部，同一个包，不同包的子类；
 * default: 类内部，同一个包；
 * private:类内部。
 *
 * 5.创建circle类，提供私有的radius属性，提供相应的get和set方法，提供求圆面积的方法。
 *
 * JavaBean是一种可重用组件：类是公共的，有一个无参构造器，有属性且有对应的get和set方法。
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/3 13:57
 * @Version: 1.0
 */
public class day10 {
    public static void main(String[] args){
        circle c = new circle();
        c.setRadius(2);
        System.out.println(c.mianji());

        circle c2 = new circle(2);
        System.out.println(c2.mianji());
    }
}
class circle{
    private double radius;

    public circle() {
    }

    public circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double mianji(){
        return Math.PI * this.radius * this.radius;
    }
}