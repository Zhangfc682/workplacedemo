package com.zfc;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-07 08:10
 * @Modified By:
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @ClassName: TreeSetTest
 * @Description
 * TreeSet练习题，重点为自然排序和定制排序
 *
 * Set中添加元素，比较的时候，先比较HashCode，然后比较equals，最后才能确定是否插入。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/7 8:10
 * @Version: 1.0
 */
public class TreeSetTest {
    @Test
    public void test(){
        //定制排序:按生日日期的先后顺序排序
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee tmpo = (Employee)o1;
                    Employee tmpo2 = (Employee)o2;

                    //年、月、日 依次进行比较
                    if ((Integer.compare(tmpo.getBirthday().getYear(),tmpo2.getBirthday().getYear()))==0){
                        if ((Integer.compare(tmpo.getBirthday().getMonth(),tmpo2.getBirthday().getMonth()))==0){
                            if ((Integer.compare(tmpo.getBirthday().getDay(),tmpo2.getBirthday().getDay()))==0){
                                return 0;
                            }else
                                return Integer.compare(tmpo.getBirthday().getDay(),tmpo2.getBirthday().getDay());

                        }else {
                            return Integer.compare(tmpo.getBirthday().getMonth(),tmpo2.getBirthday().getMonth());
                        }
                    }else
                        return Integer.compare(tmpo.getBirthday().getYear(),tmpo2.getBirthday().getYear());

                }else{
                    throw new RuntimeException("输入类型不匹配");
                }
            }
        };

        TreeSet<Employee> employees = new TreeSet<Employee>(com);

        Employee e1 = new Employee("Tom", 12, new MyDate(2001, 2, 5));
        Employee e2 = new Employee("Amy",22,new MyDate(2003,2,5));
        Employee e3 = new Employee("Mary",32,new MyDate(2006,2,5));
        Employee e4 = new Employee("Jack",2,new MyDate(2001,6,5));
        Employee e5 = new Employee("Rose",11,new MyDate(2009,3,5));

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        TreeSet<Employee> employees = new TreeSet<Employee>();  //默认按照name排序

        Employee e1 = new Employee("Tom", 12, new MyDate(2001, 2, 5));
        Employee e2 = new Employee("Amy",22,new MyDate(2003,2,5));
        Employee e3 = new Employee("Mary",32,new MyDate(2006,2,5));
        Employee e4 = new Employee("Jack",2,new MyDate(2001,6,5));
        Employee e5 = new Employee("Rose",11,new MyDate(2009,3,5));

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        //定制排序:按生日日期的先后顺序排序
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee){
                    Employee tmpo = (Employee)o1;
                    Employee tmpo2 = (Employee)o2;

                    //年、月、日 依次进行比较
                   int b1 = tmpo.getBirthday().getYear();
                   int b2 = tmpo2.getBirthday().getYear();

                   if (b1 != b2){
                       //年不同，则按照年进行比较
                       return b1 - b2;
                   }

                   int a1 = tmpo.getBirthday().getMonth();
                   int a2 = tmpo2.getBirthday().getMonth();

                   if (a1 != a2){
                       //月不同，则按照月比较
                       return a1 - a2;
                   }

//                   int c1 = tmpo.getBirthday().getDay();
//                   int c2 = tmpo2.getBirthday().getDay();
//                   if (c1 != c2){
//                       //日不同，则按照日比较
//                       return c1 - c2;
//                   }
                    return tmpo.getBirthday().getDay() - tmpo2.getBirthday().getDay();
                }else{
                    throw new RuntimeException("输入类型不匹配");
                }
            }
        };

        TreeSet<Employee> employees = new TreeSet<Employee>(com);

        Employee e1 = new Employee("Tom", 12, new MyDate(2001, 2, 5));
        Employee e2 = new Employee("Amy",22,new MyDate(2003,2,5));
        Employee e3 = new Employee("Mary",32,new MyDate(2006,2,5));
        Employee e4 = new Employee("Jack",2,new MyDate(2001,6,5));
        Employee e5 = new Employee("Rose",11,new MyDate(2009,3,5));

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}


