package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-07 09:26
 * @Modified By:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName: ListTest
 * @Description
 * 在 List中去除重复数字值，要求尽量简单（利用set的不重复性，进行去除）
 * @Author: Zhangfucai
 * @Date: 2021/4/7 9:26
 * @Version: 1.0
 */
public class ListTest {
    @Test
    public void test(){
        Set set = new HashSet();

        ArrayList list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(1));

        set.addAll(list);

        ArrayList newList = new ArrayList(set);

        Iterator iterator = newList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
