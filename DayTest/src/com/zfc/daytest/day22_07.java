package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-08 10:13
 * @Modified By:
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: day22_07
 * @Description
 * 1.Map存储数据的特点是什么？并指明key、value、entry存储数据的特点。
 * key：无序的不可重复的（Set存储）
 * value：无序的可重复的（Collection存储）
 * entry：无序的不可重复的（Set存储）
 *
 *
 * Map接口：存储双列数据，key-value键值对。
 *    HashMap：常用的实现类，线程不安全，效率高。可以存储 null的键值对。
 *      LinkedHashMap：可以按存入数据的顺序读取数据，在存入数据时会保存前后两个位置的指针。
 *    TreeMap: 可以按照key所属类的指定属性进行排序。
 *
 *    Hashtable:古老的实现类，线程安全的，效率低。不可以存储 null 的键值对。
 *      Properties：常用于读取配置文件的键值对，key-value都为String类型。
 *
 * 2.描述HashMap的底层实现原理
 * 新建 HashMap时，底层entry数组为 null；当 put第一个 key-value时创建新的数组。长度为16
 *      添加后续数据时，先比较数据的hashcode，
 *          如果hashcode不同，则直接插入到对应位置的链表中；
 *          如果hashcode相同，再比较equals方法，
 *              若equals返回true，则使用当前的value覆盖之前旧的value；
 *              若equals返回false，则添加到对应链表中。
 *      若数组长度达到 16 * 0.75 = 12，则对数组进行扩容，将旧的数据重新计算hashcode地址，重新放入新数组。
 *      若链表长度到达8且数组长度为64，则使用红黑树的结构存放后续数据。
 *
 * 3.Map中常用的实现类？有什么特点？
 * HashMap:最常用的Map实现类，线程不安全，效率高，存放key-value，可以存放null值。
 *      LinkedHashMap：HashMap的子类，存放数据时记录前后数据的指针，可以记录前后数据的位置。可以按照添加顺序遍历。
 * TreeMap：可以按照key所属类的指定属性进行排序。
 *
 * Hashtable:Map的古老实现，线程安全，效率低，不可以存放null数据。
 *      Properties:用来处理配置文件，key-value都是String类型的。
 *
 * 4.如何遍历Map中的key-value对
 *
 * 5.Collection 和 Collections的区别。
 * Collection是存放单列数据的接口。包含List和Set接口。
 * Collections是操作Collection、Map的工具类。
 *
 * ArrayList和HashMap都是线程不安全的，若要求线程安全，需要将ArrayList、HashMap转换为线程安全的。
 * 使用synchronizedList(List list),synchronizedMap(Map map)
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/8 10:13
 * @Version: 1.0
 */
public class day22_07 {
    @Test
    public void test(){
        Map map = new HashMap();

        map.put("Tim","影视剧风");
        map.put("Jack",15);
        map.put("Mary",20);
        map.put(5,8);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
    }
}
