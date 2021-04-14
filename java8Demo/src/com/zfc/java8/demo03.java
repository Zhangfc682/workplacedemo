package com.zfc.java8;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 21:40
 * @Modified By:
 */

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;

/**
 * @ClassName: demo03
 * @Description 方法引用
 * 当要传递给Lambda体的操作，已经有了实现的方法，可以使用方法引用。
 * 方法引用就是lambda表达式，通过方法的名字指向一个方法，可以认为是lambda表达式的一个语法糖。
 * lambda表达式作为函数式接口的实例，所以，方法引用也是函数式接口的实例。
 *
 * 要求：实现接口的抽象方法的参数列表和返回值类型，必须与方法引用的方法的参数列表和返回值类型保持一致。
 * 格式：使用操作符“ :: ”将类或对象与方法名分隔开来。
 *
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/12 21:40
 * @Version: 1.0
 */
public class demo03 {

    @Test
    public void test(){
        Consumer<String> con = s -> System.out.println(s);
        con.accept("你好吗");

        //println方法属于System.out对象的方法，所以通过对象调用
        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
        con1.accept("我很好");
    }
}
