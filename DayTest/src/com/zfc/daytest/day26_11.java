package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 14:17
 * @Modified By:
 */

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName: day26_11
 * @Description
 * 1.写出获取Class实例的三种常见方式
 *      1.Class clazz = Person.class;
 *      2.Class clazz = Class.forName("com.zfc.test.Person");
 *      3.Class clazz = new Person().getClass();
 *
 * 2.对Class类的理解
 * 用于创建运行时类的对象，Class实例对应着加载到内存中的一个运行时类。通过该实例可以获取运行时类的各种结构（属性，方法，注解等）
 *
 * 3.创建Class对应的运行时类的对象的通用方法，代码实现。以及这样操作，需要对应的运行时类构造器方面满足的要求。
 * Object obj = clazz.newInstance();  //需要提供运行时类的空参构造器，访问权限为公共的。
 *
 * 4.在工程Module的src下有名为“jdbc.properties”配置文件，任何获取配置文件的Tom变量。
 *
 * 5.调用方法show()
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/12 14:17
 * @Version: 1.0
 */
public class day26_11 {
    @Test
    public void test() throws IOException {
        //获取配置文件信息
        Properties pro = new Properties();

        //使用类加载器加载配置文件,配置文件相对于src目录
        ClassLoader classLoader = day26_11.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");

        pro.load(is);

        String name = pro.getProperty("name");
        System.out.println("name = " + name);
    }

    @Test
    public void test2() throws Exception {
        //利用反射调用指定方法
        Class clazz = Class.forName("com.zfc.daytest.User_demo");
        Object o = clazz.newInstance();

        Method show = clazz.getDeclaredMethod("show");
        show.setAccessible(true);
        show.invoke(o);
    }
}
