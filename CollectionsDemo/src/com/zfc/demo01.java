package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-06 09:33
 * @Modified By:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: demo01
 * @Description
 * collection每次调用iterator方法，都会从头开始，指针指向第一个元素之前。
 * List：存储有序的、可重复的数据，动态数组
 *      ArrayList：作为List接口的主要实现类；线程不安全，效率高；底层使用Object[] elementData存储。
 *      LinkedList：底层使用双向链表存储；对于频繁的插入、删除操作，效率比ArrayList高。
 *      Vector：作为List接口的古老实现；线程安全，效率低；底层使用Object[] elementData存储。
 *
 *  常用方法：
 *      增：add(Object obj)
 *      删：remove(int index) / remove(Object obj)
 *      改：set(int index, Object ele)
 *      查：get(int index)
 *      插：add(int index, Object ele)
 *      长度：size()
 *      遍历：Iterator、foreach
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/6 9:33
 * @Version: 1.0
 */
public class demo01 {

    @Test
    public void test(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        updateList(list);
        System.out.println(list);
    }

    private static void updateList(List list){
        list.remove(2);
    }
}
