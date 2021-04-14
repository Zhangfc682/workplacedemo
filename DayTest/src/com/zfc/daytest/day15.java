package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-04 09:52
 * @Modified By:
 */

/**
 * @ClassName: day15
 * @Description
 * 1.abstract能修饰哪些结构？修饰以后，有什么特点。
 * 修饰类，称为抽象类，抽象类中包含abstract修饰的抽象方法，只有方法名（只定义了一种功能的标准），没有方法体，
 * 需要在子类中重写实现方法体。
 * 抽象类不能实例化，需要提供子类去使用。
 *
 * 2.接口能否继承接口，抽象类能否实现接口，抽象类能否继承非抽象的类。
 * 接口可以继承接口，抽象类可以实现接口，抽象类可以继承非抽象的类。
 *
 * 3.声明抽象类，并包含抽象方法。测试类中创建一个继承抽象类的匿名子类的对象。
 *
 * 4.抽象类和接口的异同
 * 二者不能实例化，都可以被继承。
 * 抽象类：包含抽象方法，也可以包含正常方法，有构造器，只能单继承。
 * 接口：全部为抽象方法，没有构造器，可以多继承。
 *
 * 5.如何创建静态成员内部类和非静态成员内部类的对象。
 * Person
 *      static Dog  静态成员内部类
 *      Bird  非静态成员内部类
 *
 *    Person.Dog dog = new Person.Dog();  静态类
 *
 *    Person p = new Person();
 *    Person.Bird bird = p.new bird();  非静态类
 *
 * 内部类：允许将一个类A声明在另一个类B中，则A就是内部类，B就是外部类。
 * 成员内部类（静态、非静态）
 * 局部内部类（方法内、代码块内、构造器内）
 *
 * 内部类编译后同样会生成字节码.class文件
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/4 9:52
 * @Version: 1.0
 */
public class day15 {
    public static void main(String[] args){
        Vehicle truck = new Truck();
        truck.calcFuelEfficiency();
        truck.calcTrioDistance();

        //匿名子类实现抽象方法
        Vehicle vv = new Vehicle() {
            @Override
            public double calcFuelEfficiency() {
                System.out.println("匿名子类实现具体燃料效率方法");
                return 0;
            }

            @Override
            public double calcTrioDistance() {
                System.out.println("匿名子类实现具体计算距离方法");
                return 0;
            }
        };
        vv.calcTrioDistance();
        vv.calcFuelEfficiency();
    }
}
abstract class Vehicle{  //抽象类：只有抽象方法
    public abstract double calcFuelEfficiency();  //计算燃料效率的抽象方法
    public abstract double calcTrioDistance();  //计算行驶距离的抽象方法
}

class Truck extends Vehicle{

    @Override
    public double calcFuelEfficiency() {
        System.out.println("实现Truck具体的燃油效率方法");
        return 0;
    }

    @Override
    public double calcTrioDistance() {
        System.out.println("实现Truck具体的距离计算方法");
        return 0;
    }
}

class RiverBarge extends Vehicle{

    @Override
    public double calcFuelEfficiency() {
        System.out.println("实现RiverBarge具体的燃油效率方法");
        return 0;
    }

    @Override
    public double calcTrioDistance() {
        System.out.println("实现RiverBarge具体的距离计算方法");
        return 0;
    }
}