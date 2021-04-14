package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-03 11:42
 * @Modified By:
 */

/**
 * @ClassName: day09
 * @Description
 * 1.什么是方法重载？
 * 在同一个类中的方法，名称相同，形式参数不同（参数列表不同），返回值也不同，即方法重载。
 *
 * 2.说明Java方法中的参数传递机制的具体体现。
 * 基本数据类型为值传递，向方法中传递时传递的是一个副本；引用数据类型，传递的是对象的地址，可以通过地址改变变量的值。
 *
 * 3.成员变量和局部变量在声明的位置上、是否有默认初始值上、能否有权限修饰符上、内存分配上的差异。
 * 成员变量：声明在类的{}中，有默认初始值，有权限修饰符，内存分配在对象的堆中。
 * 局部变量：声明在方法体中，有默认初始值，没有权限修饰符，内存分配在变量栈中。
 *
 * 4.谈谈return关键字的使用。
 * 在方法内结束方法，或者返回数据。
 *
 *
 * 5.代码的内存解析。
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/3 11:42
 * @Version: 1.0
 */
public class day09 {
    public static void main(String[] args){
        day09 test = new day09();
        test.first();
    }
    public void first(){
        int i = 5;
        ValueC v = new ValueC();
        v.i = 25;
        second(v,i);
        System.out.println(v.i);
    }

    private void second(ValueC v, int i) {
        i = 0;
        v.i = 20;
        ValueC val = new ValueC();
        v = val;
        System.out.println(v.i + " " + i);
    }
}
class ValueC{
    int i =15;
}
