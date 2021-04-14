package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-03 19:48
 * @Modified By:
 */

/**
 * @ClassName: day12
 * @Description
 * 1.什么是多态性？什么是虚拟方法调用？
 * 对象的多态性：父类的引用指向子类的对象。
 * 虚拟方法调用：调用方法时，编译时看左边，运行时看右边。
 *
 *
 * 2.一个类可以有几个父类？一个父类可以有多少个子类？子类能获取直接父类的父类中的结构吗？子类能否获取父类中private权限
 * 的属性或方法。
 * 一个类可以有一个直接父类，一个父类可以有无数个子类，可以获取，能获取private权限的属性或方法（但是不能调用）。
 *
 * 3.方法的重写（override/overwrite）的具体规则有哪些？
 * 子类重写父类的方法，方法名相同，参数列表相同，返回值相同。
 * 子类继承父类以后，可以对父类中同名同参数的方法进行覆盖操作。
 *
 * 形参列表相同；权限修饰符；返回值；抛出的异常；（<=）
 *
 * 4.super调用构造器，有哪些具体的注意点。
 * super()构造器必须放在第一行。this必须放首行。
 * this(形参列表)：本类重载的其他构造器。
 * super(形参列表)：调用父类中指定的构造器。
 *
 * 5.使用this，super关键字；方法的重写、继续。
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/3 19:48
 * @Version: 1.0
 */
public class day12 {
    public static void main(String[] args){
        Cylinder cylinder = new Cylinder();
        double area = cylinder.findArea();
        System.out.println("area: " + area);

        System.out.println("volume: " + cylinder.findVolume());
    }
}

class Circle{
    private double radius;

    public Circle() {
        radius = 1;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return this.radius;
    }
    public double findArea(){
        return Math.PI * this.radius * this.radius;
    }
}

class Cylinder extends Circle{
    private double length;

    public Cylinder() {
        this.length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume(){
        return super.findArea() * this.length;
    }

    @Override
    public double findArea() {
        return 4.0/3.0 * super.findArea();
    }
}