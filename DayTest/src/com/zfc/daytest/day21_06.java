package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-06 21:24
 * @Modified By:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: day21_06
 * @Description
 * 1.集合Collection中存储的如果是自定义类的对象，需要自定义类重写哪个方法？为什么？
 * 重写equals方法，需要对自定义对象的所有属性进行对比。
 * List：重写 equals方法。
 * 调用contains、remove、retainsAll方法时会用到equals方法。
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj对象所在类重写equals()方法。
 *
 * 集合转换为数组：collection.toArray()、
 * 数组转换为集合：Arrays.asList(Arr[])
 *
 * 2.ArrayList，LinkedList，Vector三者的相同点与不同点？
 * 都属于Collection接口中List的实现类。（有序，可重复）
 * ArrayList：可变数组，底层使用数组实现，频繁的插入和删除效率低下，检索指定索引的数据效率高。线程不安全。
 * LinkedList：链表数组，底层使用双向链表实现，插入和删除效率高，检索指定索引的数据效率低。
 * Vector：向量，List接口的古老实现。线程安全，效率低。
 *
 * 3.List接口的常用方法有哪些？（增、删、改、查、插、长度、遍历）
 * add();
 * remove();
 * set();
 * get();
 * add();
 * size();返回当前元素的个数
 * iterator();
 *
 * 4.如何使用Iterator和增强for循环遍历List。
 *
 * 5.Set存放数据的特点是什么？常见的实现类有什么？
 * 无序，不可重复的数据。
 *
 * HashSet:存放数据时，需要重写自定义类的 equals()和 hashcode()方法。无序是指存入地址是通过 hashcode算法计算的，与数据添加顺序
 * 是不一致的。
 *      LinkedHashSet:在添加数据时，会存储每一个数据的前后地址索引，从而可以保持插入时的顺序不变。
 * TreeSet:可以按照添加数据类对象的指定属性排序，自定义类中重写相应的比较方法。添加的元素是相同类的对象。
 *          Comparable接口：compareTo(Object obj)
 *          Comparator接口：compare(Object obj,Object obj2)
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/6 21:24
 * @Version: 1.0
 */
public class day21_06 {
    @Test
    public void test1(){
        List list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new User("Tom",16));

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
