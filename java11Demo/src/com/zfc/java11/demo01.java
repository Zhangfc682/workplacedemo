package com.zfc.java11;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-14 10:02
 * @Modified By:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @ClassName: demo01
 * @Description
 * 局部变量类型推断
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/14 10:02
 * @Version: 1.0
 */
public class demo01 {
    @Test
    public void test(){
        //声明变量时，根据所赋的值，推断变量的类型
        var num = 10;

        var list = new ArrayList<Integer>();
        list.add(233);

        for (var i: list){
            System.out.println(i);
            System.out.println(i.getClass());
        }

//        var s = null;
    }

    @Test
    public void test2(){
        System.out.println("  ".isBlank());

        //strip():去除首尾的空白；stripTrailing：去除尾部空白；stripLeading：去除首部空格。
        //lines().count():统计行数
        Optional<Object> op = Optional.empty();

        System.out.println(op.isPresent());  //判断value是否存在 存在则返回true
        System.out.println(op.isEmpty());  //为空则返回true
    }

    @Test
    public void test3(){
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpClient.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();


    }
}
