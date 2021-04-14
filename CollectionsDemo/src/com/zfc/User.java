package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-06 20:27
 * @Modified By:
 */

/**
 * @ClassName: User
 * @Description TODO
 * @Author: Zhangfucai
 * @Date: 2021/4/6 20:27
 * @Version: 1.0
 */
public class User implements Comparable{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public int compareTo(Object o) {
        //按照姓名从小到大排序
        if (o instanceof User){
            User u = (User)o;
//            return this.name.compareTo(u.name);
            int compare = this.name.compareTo(u.name);
            if (compare != 0){
                return -Integer.compare(this.age, u.age);  //二级排序，年龄从小到大排列
            }else
                return compare;
        }else {
            throw new RuntimeException("输入的类型不匹配");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
