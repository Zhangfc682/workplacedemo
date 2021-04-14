package com.zfc.java8;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-13 09:56
 * @Modified By:
 */

import org.junit.Test;

import java.util.Optional;

/**
 * @ClassName: demo05
 * @Description
 * Optional类：是一个容器类，可以保存类型T的值，代表这个值存在。或者保存null，表示这个值不存在。
 * 原来用null表示一个值不存在，现在Optional可以更好的表达这个概念，且可以避免空指针异常。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/13 9:56
 * @Version: 1.0
 */
public class demo05 {
    @Test
    public void test(){
        Optional op1 = Optional.empty();  //初始化一个空的Optional容器
        if (!op1.isPresent()){  //判断op1是否不为空
            System.out.println("数据为空");
        }
    }

    @Test
    public void test2(){
        String str = "Hello";

        Optional<String> op1 = Optional.of(str);  //of方法中必须为非null的对象
        //get方法与of方法通常搭配使用，用于获取内部的封装的数据value
        String s = op1.get();  //获取容器中的核心数据
        System.out.println(s);
    }

    @Test
    public void test3(){
        String str = "nihao";
        str = null;
        Optional<String> op1 = Optional.ofNullable(str);  //封装数据，不要求数据非空

        String str2 = op1.orElse("shanghao");  //如果optional中的数据为null，则返回此value值

        System.out.println(str2);

    }
}
