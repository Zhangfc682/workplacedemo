package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-06 20:23
 * @Modified By:
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName: demo03
 * @Description
 * TreeSet：向TreeSet中添加的数据，要求是相同类的对象。可以按照添加元素的指定属性排序。
 *
 * 自然排序中，比较两个对象是否相同的标准为：compareTo返回0，不再是equals。
 * 定制排序中，比较两个对象是否相同的标准为：compare返回0，不再是equals。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/6 20:23
 * @Version: 1.0
 */
public class demo03 {
    @Test
    public void test(){
        Set set = new TreeSet();

//        User u = new User("Tom",12);
//        User u1 = new User("Jerry",15);
//        User u2 = new User("Jim",16);
//        User u3 = new User("Amy",11);

        set.add(new User("Tom",12));
        set.add(new User("Jerry",15));
        set.add(new User("Jim",16));
        set.add(new User("Amy",11));

        System.out.println(set);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            User u = (User) iterator.next();
            System.out.println(u.getName() + " - " + u.getAge());
        }
    }

    @Test
    public void test2(){

        Comparator com = new Comparator() { // 定制排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return -Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };

        TreeSet set = new TreeSet(com);

        set.add(new User("Tom",12));
        set.add(new User("Jerry",15));
        set.add(new User("Jim",16));
        set.add(new User("Amy",11));
        set.add(new User("Kitty",19));

        System.out.println(set);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            User u = (User) iterator.next();
            System.out.println(u.getName() + " - " + u.getAge());
        }
    }
}
