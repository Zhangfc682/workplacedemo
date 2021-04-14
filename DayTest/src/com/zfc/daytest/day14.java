package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-04 08:07
 * @Modified By:
 */

/**
 * @ClassName: day14
 * @Description
 * 1.static修饰的属性，相较于实例变量，有哪些特别之处？
 * static修饰的属性是依赖于类的，类一旦存在，该属性就存在，且只有一份。
 * 实例变量是依赖于对象的，每创建一个类的对象，实例变量就创建一次。
 *
 * 修饰属性、方法、代码块、内部类。
 *
 * 随着类的加载而加载，只加载一次，早于对象的创建，只要权限允许，可以通过对象.static属性的方式调用；
 * 存在于方法区的静态域。
 *
 * 2.final可以用来修饰哪些结构，分别表示什么意思？
 * final修饰变量，表示为常量，不可修改。
 * 修饰类，表示该类不可被继承。
 * 修饰方法，表示该方法不能被子类重写。
 *
 * 3.代码实现单例模式的饿汉式
 *  坏处：对象加载时间过长。
 *  好处：饿汉式是线程安全的。
 * 4.代码实现单例模式的懒汉式。
 *  好处：延迟对象的创建。
 *  坏处：线程不安全（目前）
 *
 *
 * 5.类的属性赋值的位置有哪些，先后顺序为何？
 * 默认初始化：
 * 显式初始化、代码块中初始化：
 * 构造器初始化：
 * 通过 obj.属性 或 obj.方法 初始化。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/4 8:07
 * @Version: 1.0
 */
public class day14 {
    public static void main(String[] args){
//        lanhan lanh = lanhan.getInstance();
//        System.out.println(args[0]);
    }
}
class lanhan{
    //单例模式的懒汉式，某个类只能存在一个对象实例
    //构造方法为私有
    private static lanhan instance = null;
    private lanhan() {
    }

    public static lanhan getInstance() {
        if (instance == null){
            instance = new lanhan();
        }
        return instance;
    }
}

class lanhan_safe{
    //线程安全，使用同步代码块包为共享对象
    private lanhan_safe(){

    }
    private static lanhan_safe instance = null;

    public static lanhan_safe getInstance() {
        if (instance == null){
            synchronized (lanhan_safe.class){
                if (instance == null)
                    instance = new lanhan_safe();
            }
        }
        return instance;
    }
}

class ehan1{
    //单例模式的饿汉式
    //私有化构造器
    private ehan1(){

    }
    //内部创建类的对象
    private static ehan1 instance = new ehan1();

    //提供公共的静态方法，返回类的对象
    public static ehan1 getInstance(){
        return instance;
    }

}
