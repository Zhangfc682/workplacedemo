package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-03 20:51
 * @Modified By:
 */

import java.util.Objects;

/**
 * @ClassName: day13
 * @Description
 * 1.如何实现向下转型？需要注意什么问题？如何解决此问题？
 * 父类对象强转为子类对象。
 * 高级类型向下转型，需要进行强制转换。
 * Man man = (Man)person;
 *
 * 可能出现ClassCastException异常：在转换之前进行判断，instanceof。
 *
 * 2.== 和 equals有何区别？
 * ==：比较两者的值,运用于基本数据类型（比较两者保存的数据）和引用数据类型（比较两者的引用地址）。
 * equals：比较两者的地址，比较引用数据类型。若重写，则比较实体内容。
 *
 * 3.重写方法：equals().
 *
 * 4.写出8种基本数据类型及其对应的包装类。
 * byte(8位) --> Byte
 * short(16位) --> Short
 * int(32位) --> Integer
 * long(64位) --> Long
 * float(32位) --> Float
 * double(64位) --> Double
 * char(16位) --> Character
 * boolean(32位) --> Boolean
 *
 * 5.基本数据类型、包装类、与String三者之间如何转换。
 * 基本数据类型可以直接装箱为包装类,包装类自动拆箱为基本数据类型；
 *
 * 基本数据类型、包装类-->String：valueOf();
 * String-->基本数据类型、包装类：parseXxx(String s)
 *
 * 包装类：使得基本数据类型具有类的特征。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/3 20:51
 * @Version: 1.0
 */
public class day13 {
    public static void main(String[] args){
        int a = 10;
        String s = String.valueOf(a);
        System.out.println(s);

        int d = Integer.parseInt(s);
        System.out.println(d);
    }

}
class User{
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj instanceof User){
            User u = (User)obj;
            return this.name == u.name && this.age == u.age;
        }
        return false;
    }
}