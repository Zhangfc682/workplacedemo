package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-04 22:30
 * @Modified By:
 */

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

/**
 * @ClassName: day19_04
 * @Description
 * 1.将字符串"2017-08-16"转换为对应的java.sql.Date类的对象。
 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  实例化格式对象
 * Date date = sdf.parse("2017-08-16");  对字符串进行解析，解析为日期对象
 * 使用该日期对象构造sql.Date
 *
 * DateTimeFormatter
 *
 * 本地日期、本地时间、本地日期时间的使用：
 * LocalDate、LocalTime、LocalDateTime：他们的实例是不可变的对象，分别表示使用ISO-8601日历相同的日期、时间、日期和时间。
 * LocalDate：代表（yyyy-MM-dd）的日期，可以存储生日、纪念日等日期。
 * LocalTime：表示一个时间，而不是日期。
 * LocalDateTime：表示日期和时间。
 *
 * Instant：时间线上的一个瞬时点，用来记录应用程序中的时间戳。
 *
 * 2.解释何为编码，解码；日期时间格式化，解析。
 * 编码：字符串->字节
 * 解码：字节->字符串
 * 日期格式化：日期->字符串
 * 解析：字符串->日期
 *
 * 3.自定义Person类，实现自然排序（按姓名从小到大排序）
 * 比较器：需要比较对象的大小，实现接口Comparable和Comparator.
 * Comparable:一旦确定，保证Comparable接口实现类的对象在任何位置都可以比较大小。
 * Comparator:属于临时性的比较。
 *
 * 像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式。
 * 重写compareTo(obj)的规则：
 *      如果当前对象this大于形参对象obj，则返回正整数。小于返回负整数，等于返回0
 *
 * class Person{
 *     name;
 *     age
 * }
 *
 * 4.提供定制排序涉及到的接口的实现类对象，按Person类的年龄从小到大排序。
 * 当元素的类型没有实现Comparable接口而又不方便修改代码，考虑使用Comparator的对象来排序。
 * 重写compare(Object o1,Object o2)方法，比较o1和o2的大小。
 * 大于，返回正整数；相等返回0；小于返回负数
 *
 * 5.JDK8之前和JDK8中日期、时间相关的类有哪些。
 * java.util.Date,java.sql.Date --> Instant
 * SimpleDateFormat -- > DateTimeFormatter
 * Calendar -- > LocalDate,LocalTime,LocalDateTime
 *
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/4 22:30
 * @Version: 1.0
 */
public class day19_04 {
    @Test
    public void test(){
        String[] arr = new String[]{"AA","CC","KK","MM","GG","JJ","DD"};
        Arrays.sort(arr, new Comparator() {
            //按字符串从大到小的顺序排序
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }

//                return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("2017-06-11");
            java.sql.Date date1 = new java.sql.Date(date.getTime());
            System.out.println(date1);
            System.out.println(date1.getClass());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //格式化或解析日期、时间。
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
//        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;  //预定义的标准格式
        LocalDateTime localDateTime = LocalDateTime.now();  //将日期格式化为字符串
        String str1 = dtf.format(localDateTime);
        System.out.println(str1);

        //字符串解析为日期
        TemporalAccessor parse = dtf.parse("2019-02-02 03:50:21");
//        TemporalAccessor parse = dtf.parse(str1);
        System.out.println(parse);
        System.out.println(parse.getClass());

    }
}
class Person implements Comparable{
    private String name;
    private int age;

    @Override
    public int compareTo(Object o) {
        if ((o instanceof Person)){
            Person s = (Person)o;

            if (this.age > s.age){
                return 1;
            }else if (this.age < s.age){
                return -1;
            }else {
                return -this.name.compareTo(s.name);
            }
        }
        throw new RuntimeException("输入对象类型不一致");
//    return 0;
//        return 0;
    }
}