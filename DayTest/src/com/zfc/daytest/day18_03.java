package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-04 17:19
 * @Modified By:
 */

/**
 * @ClassName: day18_03
 * @Description
 *
 * String:字符串，使用一对""引起来表示。
 * String声明为final的，不可被继承。
 * String实现了Serializable接口，表示字符串是支持序列化的。
 *          实现了Comparable接口，表示String可以比较大小。
 *          内部定义了final char[] value用于存储字符串数据。
 *          代表不可变的字符序列。
 *          通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串声明在字符串变量池中。
 *          字符串变量池不会存储相同内容的字符串。
 *
 * 1.画出如下几行代码内容的内存结构：
 * String s1 = "hello";  直接在常量池创建"hello"
 * String s2 = "hello";  s2指向常量池已有的"hello"
 * String s3 = new String("hello");  先在堆空间中创建String对象，然后在常量池指向"hello"
 * s1 += "world";  重新在常量池创建"hello world"
 *
 * s3 = s1 + "world";  在堆空间中新new，然后再指向常量池中的常量。
 *
 * 调用intern()方法，则返回再常量池中的地址。
 *
 * 栈，堆，常量池。
 *
 * 2.如何理解String类的不可变性。
 * String对应常量池的值是不可以修改的，若需要拼接，则需要在常量池中新建对象。
 *
 * 3.String类是否可以被继承？为什么
 * 不可以被继承，为final类型。
 *
 *
 * String s = new String("hello");在内存中创建了几个对象。
 * 创建了两个对象，String对象在堆空间中，"hello"内容在常量池空间中
 *
 * 4.String、StringBuffer、StringBuilder的对比。
 * String：不可变的字符序列，底层使用char[]存储；
 * StringBuffer：可变的字符序列，线程安全的，效率低，底层使用char[]存储；
 * StringBuilder：可变的字符序列，线程不安全，效率高，底层使用char[]存储；
 *
 * 扩容时，默认扩容为原来的2倍+2，同时将原有数组中的元素赋值到新的数组中。
 *
 * 5.String的常用方法有哪些。
 * length()/charAt()/equals()/compareTo()/startsWith()/endsWith()/contains()/indexOf()/lastIndexOf()/getBytes()/
 * toCharArray()/valueOf()/
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/4 17:19
 * @Version: 1.0
 */
public class day18_03 {
}
