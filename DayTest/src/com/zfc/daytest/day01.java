package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-02 09:13
 * @Modified By:
 */

/**
 * @ClassName: day01
 * @Description 每日一考
 * 1.JDK，JRE，JVM三者之间的关系，以及JDK、JRE包含的主要结构有哪些？
 * JDK：Java Development Kit,Java开发工具包，JDK=JRE+Java的开发工具（javac.exe,java.exe,javadoc.exe）
 * JRE：java runtime entirement,Java运行时环境，JRE=JVM+Java的核心类库。
 * JVM：Java Virtual Michine，Java虚拟机，
 *
 * 2.为什么要配置path环境变量？如何配置？（windows操作系统执行命令时所要搜寻的路径）
 * 环境变量可以让计算机直接执行操作指令，在任何路径下都可以执行Java开发工具。
 *
 * 3.常用的几个命令行操作有哪些？
 * javac:编译.java文件为字节码文件.class
 * java: 运行字节码文件.class
 *
 * 4.创建如下类，使得运行的话可以输出（姓名，性别，住址）
 * person类
 *
 * 5.编译和运行上述代码。
 * javac编译；java运行。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/2 9:13
 * @Version: 1.0
 */
public class day01 {
    public static void main(String[] args){
        person p = new person("Jack","男","泰坦尼克号");
        p.getInfo();
    }
}

class person{
    public String name;
    public String sex;
    private String place;

    public person() {
    }

    public person(String name, String sex, String place) {
        this.name = name;
        this.sex = sex;
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void getInfo(){
        System.out.println("姓名：" + this.name + " 性别：" + this.sex + " 地址：" + this.place);
    }
}