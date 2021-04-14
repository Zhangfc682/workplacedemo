package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-06 15:10
 * @Modified By:
 */

/**
 * @ClassName: demo02
 * @Description
 * Collection子接口：
 *      Set:没有重复元素，无序的。
 *          HashSet:作为Set接口的主要实现类；线程不安全的；可以存储null值。
 *              LinkedHashSet:作为HashSet的子类，遍历内部数据时，可以按照添加的顺序遍历。
 *          TreeSet:可以按照添加对象的指定属性，进行排序。
 *
 *  无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值添加。
 *  不可重复性：保证添加的元素按照equals判断时，不能返回true。相同的元素只能添加一个。
 *
 *  添加元素的过程（以HashSet为例）：
 *      向HashSet中添加元素a，首先调用元素a所在类的hashCode方法，计算a的哈希值，此哈希值算出HashSet底层数组中的索引位置，
 *      判断此位置上是否已经有元素。
 *          如果此位置上没有其他元素，则a添加成功。
 *          如果此位置上有其他元素b（或者以链表形式存在多个元素），则比较a和b的哈希值：
 *              如果哈希值不相同，则元素a添加成功；
 *              如果哈希值相同，调用a的equals方法，与b比较：
 *                  若equals返回true，则元素a添加失败；
 *                  若equals返回false，则元素a添加成功。
 *
 *  元素a是与已经存在指定索引位置上以链表方式存储。
 *
 *  HashSet底层：数组 + 链表
 *
 *  向Set中添加的数据，其所在的类一定要重写hashCode和equals方法。重写的方法尽可能保持一致性：相等的对象必须具有相等的散列码。
 *
 *  LinkedHashSet：可以按添加数据的顺序遍历。作为HashSet的子类，在添加数据的时候，每个数据还维护了两个引用，记录此数据的前一个
 *  数据和后一个数据。对于频繁的遍历操作，LinkedHashSet效率高于HashSet。
 *
 *  TreeSet：可以按照对象的指定属性进行排序。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/6 15:10
 * @Version: 1.0
 */
public class demo02 {
}
