package com.zfc.java8;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 21:04
 * @Modified By:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @ClassName: demo02
 * @Description
 * 内置的核心函数式接口
 * 消费型接口 Consumer<T>    void accept(T t)
 * 供给型接口 Supplier<T>    T get()
 * 函数型接口 Function<T,R>  R apply(T t)
 * 断定型接口 Predicate<T>   boolean test(T t)
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/12 21:04
 * @Version: 1.0
 */
public class demo02 {
    @Test
    public void test1(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("价格为： " + aDouble);
            }
        });

        happyTime(500,money -> System.out.println("价格为： " + money));
    }
    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","普京","天津","东京");

        List<String> list1 = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(list1);

        List<String> list2 = filterString(list, s -> s.contains("京"));
        System.out.println(list2);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre){
        //根据某种规则过滤集合中的字符串，规则由Predicate决定
        ArrayList<String> filterList = new ArrayList<>();

        for (String s : list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;
    }
}
