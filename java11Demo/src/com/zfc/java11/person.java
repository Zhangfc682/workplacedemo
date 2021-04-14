package com.zfc.java11;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-13 22:21
 * @Modified By:
 */

/**
 * @ClassName: demo01
 * @Description TODO
 * @Author: Zhangfucai
 * @Date: 2021/4/13 22:21
 * @Version: 1.0
 */
public class person {
    private String name;
    private int age;

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
