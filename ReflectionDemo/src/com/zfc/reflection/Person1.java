package com.zfc.reflection;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 10:45
 * @Modified By:
 */

/**
 * @ClassName: Person1
 * @Description TODO
 * @Author: Zhangfucai
 * @Date: 2021/4/12 10:45
 * @Version: 1.0
 */
@MyAnnotation(value = "hi")
public class Person1 extends Creature<String> implements Comparable<String>, MyInterface{

    private String name;
    int age;
    public int id;

    public Person1(){}

    @MyAnnotation(value = "abc")
    private Person1(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    Person1(String name, int age){
        this.name = name;
        this.age = age;
    }

    private static void showMe(){
        System.out.println("我是一个可爱的人");
    }

    @MyAnnotation
    private String showNation(String nation){
        System.out.println("我的国籍是： " + nation);
        return nation;
    }

    public String display(String interests){
        return interests;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }
}
