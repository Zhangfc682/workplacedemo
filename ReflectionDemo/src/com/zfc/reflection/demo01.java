package com.zfc.reflection;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 08:07
 * @Modified By:
 */

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ClassName: demo01
 * @Description
 * 反射：动态语言的关键，允许程序在执行期间借助于反射API取得任何类的内部消息，并能直接操作任意对象的内部属性及方法。
 *
 * 熟练掌握：
 * 1.获取Class实例
 *      1.Class clazz1 = Person.class;
 *      2.Class clazz2 = new Person().getClass();
 *      3.Class clazz3 = Class.forName("com.zfc.reflection.Person");  常用方法
 *      4.Class clazz4 = demo01.class.getClassLoader().loadClass("com.zfc.reflection.Person");
 *
 * 2.创建运行时类的对象
 *      Object obj = clazz.newInstance();  //调用运行时类的可访问的空参构造器
 *
 * 3.调用运行时类的指定结构（属性，方法，构造器）
 *  调用：
 *      clazz.getDeclaredField(String name):获取指定声明的属性；
 *      clazz.getField(String name):获取public权限的属性；（通常不使用）
 *
 *      clazz.getDeclaredMethod(String name, params):获取指定的方法(非静态方法，需要使用对象进行调用)
 *      静态方法调用时，不需要指定对象
 *
 *      clazz.getDeclaredConstructor(params):调用指定的构造器
 *      constructor.newInstance():新建对象
 *
 *  获取：
 *      1.getFields():获取当前运行时类及其父类中声明为public权限的属性
 *      2.getDeclaredFields():获取当前运行时类自己的所有属性（不包含父类中的属性）
 *      3.访问权限修饰符 数据类型 变量名：
 *          getModifiers():返回数字表示不同权限
 *          getType():获取数据类型
 *          getName():获取变量名
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/12 8:07
 * @Version: 1.0
 */
public class demo01 {

    //反射之前：可以创建Person对象，通过对象调用内部的属性和方法，无法调用私有的内部结构。

    //使用反射
    @Test
    public void test() throws Exception {
        //获取Person类对象
        Class clazz = Person.class;
        //获取构造方法
        Constructor cons = clazz.getConstructor(String.class, int.class);
        //使用构造方法创建对象
        Object obj = cons.newInstance("Tom", 12);
        System.out.println(obj.toString());

        //调用指定对象的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(obj,8);
        System.out.println(obj.toString());

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(obj);

        //通过反射调用私有的结构
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);  //私有的构造器
        cons1.setAccessible(true);  //设置可获取性，才能正常使用
        Person p = (Person) cons1.newInstance("Jerry");
        System.out.println(p);

        Field name = clazz.getDeclaredField("name");// 获取私有的属性
        name.setAccessible(true);
        name.set(p,"Mike");
        System.out.println(p);

        Method nation = clazz.getDeclaredMethod("nation", String.class); // 获取私有方法
        nation.setAccessible(true);
        String na = (String) nation.invoke(p, "中国");  //方法返回值
        System.out.println(na);
    }

    @Test
    public void test2() throws ClassNotFoundException {
        /*
        * 程序经过javac编译后，生成.class文件，使用java命令运行class文件，会将字节码文件加载到内存中，称为类的加载。
        * 加载到内存中的类，称为运行时类。
        *
        * */

        //Class实例就对应着一个运行时类。获取Class类的实例方法：
        Class<Person> clazz1 = Person.class;  //调用运行时类的属性 .class
        System.out.println(clazz1);

        //通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        System.out.println(clazz2);

        //调用Class.forName(String classPath)
        Class<?> clazz3 = Class.forName("com.zfc.reflection.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);  //加载到内存中的运行时类，会缓存一定的时间，通过不同的方式获取到同一个
                                                // 运行时类
        System.out.println(clazz3 == clazz2);

        //使用类的加载器
        ClassLoader classLoader = demo01.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.zfc.reflection.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);
    }

    @Test
    public void test3() throws IOException {
        Properties pros = new Properties();

        //使用类加载器加载配置文件,配置文件相对于src目录
        ClassLoader classLoader = demo01.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");

        pros.load(is);
        String name = pros.getProperty("name");
        String age = pros.getProperty("age");
        System.out.println("name: " + name + " age: " + age);
    }

    @Test
    public void test4() throws Exception {
        //创建运行时类的对象
        Class<Person> clazz = (Class<Person>) Class.forName("com.zfc.reflection.Person");
        Person o = clazz.newInstance();  //内部使用的是无参构造器（要求运行时类提供可以访问的空参构造器）
        System.out.println(o);
    }

    @Test
    public void test5() throws Exception {
        //调用运行时类的指定属性
        Class<Person1> clazz = (Class<Person1>) Class.forName("com.zfc.reflection.Person1");
        Person1 p = clazz.newInstance();

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"Jack");

        System.out.println(name.get(p));
    }

    @Test
    public void test6() throws Exception {
        //获取运行时类的指定非静态方法
        Class<Person1> clazz = Person1.class;
        Person1 p = clazz.newInstance();

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object o = showNation.invoke(p, "中国");
        System.out.println((String)o);

        Method showMe = clazz.getDeclaredMethod("showMe");  //静态方法调用时，不需要指定对象
        showMe.setAccessible(true);
        Object invoke = showMe.invoke(null);
        System.out.println(invoke);
    }

    @Test
    public void test7() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //调用指定的构造器
        Class<Person1> clazz = Person1.class;
        Constructor<Person1> cons = clazz.getDeclaredConstructor(String.class);

        cons.setAccessible(true);
        Person1 p = cons.newInstance("Tom");
        System.out.println(p.toString());
    }
}
