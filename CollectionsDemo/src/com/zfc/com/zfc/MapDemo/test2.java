package com.zfc.com.zfc.MapDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-08 09:34
 * @Modified By:
 */

import com.zfc.Car;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName: test2
 * @Description
 * 2.请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字。
 * @Author: Zhangfucai
 * @Date: 2021/4/8 9:34
 * @Version: 1.0
 */
public class test2 {
    public static void main(String[] args){
//        HashMap map = new HashMap();
        //定制排序，按照num从大到小排序
        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Car && o2 instanceof Car){
                    Car ca1 = (Car)o1;
                    Car ca2 = (Car)o2;

                    if (ca1.getNum() != ca2.getNum()){
                        return -Integer.compare(ca1.getNum(),ca2.getNum());  //分数从大到小
                    }
                    return ca1.getName().compareTo(ca2.getName()); // 姓名从小到大
                }
                throw new RuntimeException("输入类型不匹配");
            }
        });
        //将分数作为学生的属性，按分数属性进行比较
        Car c1 = new Car("Jack", 55);
        Car c2 = new Car("Kobe", 69);
        Car c3 = new Car("James", 78);
        Car c4 = new Car("Rose", 89);
        Car c5 = new Car("Mary", 36);

        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(c4);
        set.add(c5);

        Object[] objects = set.toArray();
        System.out.println("分数前三名：");
        for (int i = 0 ; i < 3; i++){
            Car o = (Car) objects[i];
            System.out.println(o.toString());
        }
//        System.out.println(set);
//        Iterator iterator = set.iterator();
//        for (Object t : set) {
//            System.out.println(set.);
//        }
    }
}
