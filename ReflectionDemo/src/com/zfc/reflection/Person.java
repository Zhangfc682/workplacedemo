package com.zfc.reflection;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 08:18
 * @Modified By:
 */

/**
 * @ClassName: Person
 * @Description TODO
 * @Author: Zhangfucai
 * @Date: 2021/4/12 8:18
 * @Version: 1.0
 */
public class Person {
    private String name;
    public int age;

    public void show(){
        System.out.println("我是一个人");
    }

    private String nation(String nation){
        System.out.println("我是国籍： " + nation);
        return nation;
    }

    private Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
