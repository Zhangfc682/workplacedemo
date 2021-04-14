package com.zfc.java8;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 19:35
 * @Modified By:
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @ClassName: demo01
 * @Description
 * Lambda表达式：是一个匿名函数，理解为一段可以传递的代码（将代码像数据一样进行传递）
 * (o1,o2) -> Integer.compare(o1,o2);
 * ->:lambda操作符 或 箭头操作符
 * 左边：lambda形参列表（抽象方法中抽象方法的形参列表）
 *      参数类型可以省略；若只有一个参数，则小括号可以省略；两个及以上参数，小括号不可省略
 *
 * 右边：lambda体（其实就是重写的抽象方法的方法体）
 *      使用大括号包裹；如果只有一条执行语句，则可以省略return和大括号；
 *
 * lambda表达式的本质：作为接口的实例。视为接口中需要实现的具体方法的简便写法。是一个接口的实现类。
 *
 * 若一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口。可以通过Lambda表达式创建该接口的对象。
 * 使用@FunctionalInterface注解，检查是否为函数式接口。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/12 19:35
 * @Version: 1.0
 */
public class demo01 {
    @Test
    public void test(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京天安门");
            }
        };
        r1.run();

        //Lambda表达式
        Runnable r2 = () -> System.out.println("我爱中国");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare = com1.compare(45, 32);
        System.out.println(compare);

        //Lambda表达式
        Comparator<Integer> com2 = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println(com2.compare(45,56));

        //方法引用
        Comparator<Integer> com3 = Integer::compare;
        System.out.println(com3.compare(32,54));

    }

    @Test
    public void test3(){
        //无参，无返回值
        Runnable r1 = () -> System.out.println("我是Lambda表达式体");
        r1.run();

        //需要一个参数，但是没有返回值
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("你在说什么");

        Consumer<String> con1 = (s) -> System.out.println(s);
        con1.accept("你在bb什么");

        Consumer<String> con2 = s -> System.out.println(s);  //只有一个参数，则省略小括号
        con1.accept("你在bb什么");

        //需要两个及以上的参数，多条执行语句，并且可以有返回值。
        Comparator<Integer> com = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        int compare = com.compare(12, 56);
        System.out.println(compare);

        //当只有一条语句时，return与大括号若有，都可以省略
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1,o2);
        System.out.println(com2.compare(56,12));
    }
}
