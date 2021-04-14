package com.zfc.com.zfc.MapDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-07 09:46
 * @Modified By:
 */

import com.zfc.Car;
import com.zfc.Employee;
import com.zfc.MyDate;
import com.zfc.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * @ClassName: demo01
 * @Description
 *
 * Map:双列数据，存储key-value对的数据
 *      HashMap：作为Map的主要实现类；线程不安全，效率高；可以存储null的key和value。（底层为数组+链表+红黑树）
 *          LinkedHashMap：保证在遍历 map元素时，可以按照添加的顺序实现遍历。在原有的HashMap底层结构基础上，添加了指向
 *          前后元素的指针。频繁的遍历操作，执行效率高于HashMap。
 *      TreeMap：按照添加的key-value对排序，实现排序遍历。（以 key值为准实现排序）
 *      Hashtable：作为古老的实现类；线程安全，效率低；不能存储null的key和value。
 *          Properties：常用来处理配置文件。key和 value都是String类型。
 *
 * Key-Value的特点：
 *      Map中的 key：无序的不可重复的，使用Set存储所有的key；（key所在的类要重写equals和hashCode方法，以HashMap为例）
 *      Map中的 value：无序的可重复的，使用Collection存储所有的value；（value所在的类要重写 equals方法）
 *      key-value键值对，组成一个对象 entry：
 *          map中的entry：无序的不可重复的，使用Set存储所有的entry。
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/7 9:46
 * @Version: 1.0
 */
public class demo01 {

    @Test
    public void test1(){
        TreeMap treeMap = new TreeMap();
        User u1 = new User("Tom", 12);
        User u2 = new User("Amy", 11);
        User u3 = new User("Rose", 13);
        User u4 = new User("Jack", 15);

        treeMap.put(u1,96);
        treeMap.put(u2,56);
        treeMap.put(u3,85);
        treeMap.put(u4,89);

        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        TreeMap treeMap = new TreeMap();
        Employee u1 = new Employee("Tom", 12, new MyDate(2001, 2, 5));
        Employee u2 = new Employee("Mary", 112, new MyDate(2008, 3, 5));
        Employee u3 = new Employee("Jack", 122, new MyDate(2005, 6, 5));
        Employee u4 = new Employee("Jim", 56, new MyDate(2005, 6, 5));

        treeMap.put(u1,65);
        treeMap.put(u2,98);
        treeMap.put(u3,56);
        treeMap.put(u4,59);

        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //向TreeMap中添加key-value，要求key必须由同一个类创建的对象，按照key进行排序
    @Test
    public void test(){
        //自然排序：按照name从小到大、age从大到小
        TreeMap treeMap = new TreeMap();

        Car c1 = new Car("Jar", 56);
        Car c2 = new Car("Jar", 59);
        Car c3 = new Car("Amy", 51);
        Car c4 = new Car("Mary", 50);

        treeMap.put(c1,89);
        treeMap.put(c2,45);
        treeMap.put(c3,32);
        treeMap.put(c4,65);

        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test4(){
        //定制排序
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //name从小到大，num从大到小
                if (o1 instanceof Car && o2 instanceof Car){
                    Car c1 = (Car)o1;
                    Car c2 = (Car)o2;

                    if (c1.getName() != c2.getName()){
                        return c1.getName().compareTo(c2.getName());
                    }

                    return -Integer.compare(c1.getNum(),c2.getNum());
                }
                throw new RuntimeException("输入类型不匹配");
            }
        };

        TreeMap treeMap = new TreeMap(comparator);

        Car c1 = new Car("Jar", 56);
        Car c2 = new Car("Jar", 59);
        Car c3 = new Car("Amy", 51);
        Car c4 = new Car("Mary", 50);

        treeMap.put(c1,89);
        treeMap.put(c2,45);
        treeMap.put(c3,32);
        treeMap.put(c4,65);

        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
