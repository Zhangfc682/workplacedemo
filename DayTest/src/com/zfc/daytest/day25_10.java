package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 20:27
 * @Modified By:
 */

/**
 * @ClassName: day25_10
 * @Description
 * 1.一个IP对应着哪个类的一个对象，如何实例化，两个常用的方法？
 * InetAddress类，
 * 实例化：InetAddress.getByName(String host);
 *        InetAddress.getLocalHost(),本机IP
 * getHostName:获得主机名
 * getHostAddress:获得IP地址
 *
 * 2.传输层TCP和UDP的主要区别？
 * TCP：面向连接的，安全的可靠的(三次握手)，进行大数据量的传输，效率低
 * UDP：面向非连接的，不安全的，以64k的数据报传输，效率高
 *
 * 3.什么是URL？
 * 统一资源定位符，为互联网中的一个资源的地址（Uniform Resource Location）
 *  https://localhost:8080/webapps/dest.jpg?usernam=Tom&password=123
 *
 * 4.对象序列化的理解。
 * 将Java中的实例对象持久化为硬盘中的一个文件，并且可以通过互联网进行跨平台传输，通过反序列化恢复为程序中的一个对象。
 *
 * 5.实现序列化的满足条件？
 * 实现Serializable接口，确定统一的序列化ID。(序列版本号)
 * 对象的属性同样是可序列化的。（基本数据类型与引用数据类型，自定义类）
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 20:27
 * @Version: 1.0
 */
public class day25_10 {
}
