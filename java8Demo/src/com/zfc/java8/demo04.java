package com.zfc.java8;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-13 08:03
 * @Modified By:
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName: demo04
 * @Description
 * Stream API：
 * Stream API将函数式编程风格引入Java中。是处理集合的关键抽象概念，可以指定你希望对集合进行的操作，可以执行非常复杂
 * 的查找、过滤、映射数据等操作。类似于使用SQL执行的数据库查询。
 *
 * Stream和Collection集合的区别：Collection是一种静态的内存数据结构，而Stream是有关计算的。前者主要面向内存的，后者
 * 主要面向CPU，通过CPU实现计算。
 *
 * Stream自己不会存储元素。
 * Stream不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * Stream操作是延迟执行的。意味着他们会等到需要结果的时候才执行。
 *
 * 三个步骤：
 *  1.创建Stream：一个数据源（集合、数组），获取一个流
 *  2.中间操作：一个中间操作链，对数据源的数据进行处理。
 *  3.终止操作：一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/13 8:03
 * @Version: 1.0
 */
public class demo04 {
    @Test
    public void test(){
        //创建Stream方式：通过集合
        List<String> list = Arrays.asList("aa","aas","bb","vbc");
        Stream<String> stream = list.stream();//返回一个顺序流

        Stream<String> parallelStream = list.parallelStream(); //返回一个并行流

        //通过数组
        int[] arr1 = new int[]{1,2,3,5,6};
        IntStream stream1 = Arrays.stream(arr1);

        //通过Stream.of()静态方法创建
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4);

        //创建无限流
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void test2(){
        //中间操作：多个中间操作连接起来形成一个流水线，除非流水线上出发终止操作，否则中间操作不会执行任何处理
        //而在终止操作时一次性全部处理，称为”惰性求值“。
        //筛选与切片
        List<Integer> list = Arrays.asList(1,2,5,4,7,92,2);
        Stream<Integer> stream = list.stream();

        stream.filter(e -> e < 10).forEach(System.out::println);

        System.out.println("*************");
        //limit(n):截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println("*************");
        //skip(n):跳过元素，返回一个扔掉前n个元素的流
        list.stream().skip(3).forEach(System.out::println);

        System.out.println("*************");
        //distinct():筛选，通过hashcode和equals去除重复元素
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test3(){
        //映射：map(Function f)  接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被应用到每一个元素
        List<String> list = Arrays.asList("aa","vv","cc");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        //flatMap(Function f)  接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流

    }

    @Test
    public void test4(){
        //排序
        List<Integer> list = Arrays.asList(1,4,7,2,1,4,6,3,5,4,12);
        list.stream().sorted().forEach(System.out::println);  //自然排序：sorted，需要实现Comparable接口

        //sorted(Comparator com):定制排序
    }

    @Test
    public void test5(){
        //终止操作
        //匹配与查找
        List<Integer> list = Arrays.asList(12,45,95,32,1,4,7,8);
        Stream<Integer> stream = list.stream();
        boolean allMatch = stream.sorted().allMatch(integer -> integer < 10); //allMatch(): 检查所有元素均满足条件
        System.out.println(allMatch);

        System.out.println("************");
        //anyMatch(): 检查是否至少匹配一个元素
        boolean b = list.stream().anyMatch(p -> p < 10);
        System.out.println(b);

        //归约reduce：可以将流中元素反复结合起来，得到一个值，返回T
        List<Integer> list1 = Arrays.asList(1, 5, 9, 7, 5, 3);
        Integer reduce = list1.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

    }

    @Test
    public void test6(){
        //收集：collect()  将流转换为其他形式。
        List<Integer> list = Arrays.asList(1, 2, 4, 7, 9);
        Set<Integer> collect = list.stream().collect(Collectors.toSet());
        collect.forEach(System.out::println);
    }
}
