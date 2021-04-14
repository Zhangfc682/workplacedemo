package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 11:18
 * @Modified By:
 */

import java.io.Serializable;

/**
 * @ClassName: person
 * @Description
 * 创建自定义可序列化对象，需要实现Serializable接口，并且提供序列化ID
 * 内部的所有属性也必须可序列化
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 11:18
 * @Version: 1.0
 */
public class person implements Serializable {
    private String name;
    private int age;

    public static final long serialVersionUID = -68L;

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public person() {
    }
}
