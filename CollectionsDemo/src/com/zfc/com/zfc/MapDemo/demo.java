package com.zfc.com.zfc.MapDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-08 08:35
 * @Modified By:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: demo
 * @Description
 * Collections:操作Collection、Map的工具类。
 *
 * Collection和 Collections的区别：
 * Collection是单列数据接口，Collections是操作 Collection和 Map的工具类。
 *
 * 常用方法：
 * reverse(List):反转 List中元素的顺序。
 * shuffle(List):对List集合元素进行随机排序。
 * sort(List, Comparator):根据指定的Comparator对List元素进行排序。
 * sort(List):根据元素的自然顺序对指定List集合元素按升序排序。
 * swap(List, int, int):将指定List集合中i处的元素和j处的元素进行交换。
 *
 * Object max(Collection):根据元素的自然排序，返回给定集合中的最大元素。
 * Object max(Collection, Comparator):根据Comparator指定的顺序，返回给定集合中的最大元素。
 * Object min(Collection):
 * Object min(Collection, Comparator):
 * int frequency(Collection,Object):返回指定集合中指定元素的出现次数。
 * void copy(List dest, List src):将src中的内容复制到dest中。
 * boolean replaceAll(List list,Object oldVal,Object newVal):使用新值替换list中的旧值。
 *
 * Collections类中提供了多个synchronizedXxx()方法，该方法可使指定集合包装成线程同步的集合，从而解决多线程并发访问时的安全问题。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/8 8:35
 * @Version: 1.0
 */
public class demo {
    @Test
    public void test(){
        ArrayList list = new ArrayList();

        list.add(123);
        list.add(456);
        list.add(1);
        list.add(23);

        System.out.println(list.size());

        List dest = Arrays.asList(new Object[list.size()]);//将数组转换为列表进行初始化
        System.out.println(dest.size());

        Collections.copy(dest,list);
        System.out.println(dest);
    }
}
