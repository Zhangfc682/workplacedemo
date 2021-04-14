package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-06 08:06
 * @Modified By:
 */

/**
 * @ClassName: day20_05
 * @Description
 * 1.什么是枚举类？枚举类的对象声明的修饰符都有哪些？
 * Enum，类中的每一个元素就是枚举类的对象。类中的对象的个数是确定的，有限个。
 * 对象的修饰符为 public static final，通过类名直接调用。
 *
 * 当需要定义一组常量时，建议使用枚举类。如果枚举类只有一个对象，则可以作为单例模式的实现方式。
 *
 * 2.什么是元注解？说说Retention和Target元注解的作用。
 * 对现有的注解进行解释说明的注释。
 * Retention：指明所修饰的注解的生命周期，SOURCE CLASS（默认行为，所修饰注解会编译为字节码） RUNTIME（所修饰注解在运行时会加载
 * 到内存中）
 * Target：指明被修饰的元注解可以用于修饰哪些程序元素。
 *
 * Annotation的使用示例：
 * 生成文档相关的注解；在编译时进行格式检测（@Override，@Deprecated，@SuppressWarnings）；跟踪代码的依赖性。
 *
 * 通过反射来进行获取、调用注解，要求元注解声明的生命周期为RUNTIME。
 *
 * 3.说说集合框架都有哪些接口，存储数据的特点是什么？
 * Collection接口：单列集合，用来存储一个一个的对象
 *      -List接口：存储有序的、可重复的数据。（动态数组）
 *          -ArrayList、LinkedList、Vector
 *      -Set接口：存储无序的、不可重复的数据。（集合）
 *          -HashSet、LinkedHashSet、TreeSet
 *
 * Map接口：双列集合，用来存储一对（key-value）数据
 *      -HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 * 集合与数组：都是对多个数据进行存储操作的结构，简称Java容器。数组的长度是固定的，元素类型是相同的。
 *
 *
 * 4.比较throw和throws的异同。
 * throw：生成一个异常对象，使用在方法内部，手动抛出异常对象。
 * throws：处理异常的方式，使用在方法声明处。（对应try-catch方式）
 *
 * 5.同步代码块中同步监视器和共享数据的理解及各自要求。
 * 同步监视器：各个线程之间共同持有的锁，任何类的对象都可以做同步监视器，被运行时的线程所持有，多个线程共用同一把锁。
 *
 * 共享数据：各个线程之间操作的公共数据，具有线程安全问题。需要使用同步机制将操作共享数据的代码包起来。
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/6 8:06
 * @Version: 1.0
 */
public class day20_05 {
}
