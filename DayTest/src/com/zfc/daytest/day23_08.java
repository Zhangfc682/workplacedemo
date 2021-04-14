package com.zfc.daytest;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-09 09:44
 * @Modified By:
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @ClassName: day23_08
 * @Description
 * 1.如何遍历Map的key集，value集，key-value集，使用上泛型。
 *
 *
 * 2.写出使用Iterator和增强for循环循环遍历List<String>的代码，使用上泛型
 *
 * 3.提供一个方法，用于遍历获取HashMap<String,String>中的所有value，并存放在List中返回。考虑上集合中泛型的使用
 *
 * 4.创建一个与a.txt文件同目录下的另外一个文件b.txt
 *
 * 5.Map接口中常用方法有哪些。
 * 增：put(k,v)
 * 删：remove(k)
 * 改：put(k,v)
 * 长度：map.size()
 * 插：put(k,v)
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/9 9:44
 * @Version: 1.0
 */
public class day23_08 {
    @Test
    public void test1(){
        //1.如何遍历Map的key集，value集，key-value集，使用上泛型。
        //泛型相当于标签，指明容器中能够存放的数据类型，包括引用数据类型，自定义类
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"Tom");
        map.put(2,"Amy");
        map.put(3,"Jerry");

        //key集
        Set<Integer> keySet = map.keySet();
        System.out.println(keySet);

        Collection<String> values = map.values();
        System.out.println(values);

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        System.out.println(entrySet);
    }

    @Test
    public void test2(){
    //  写出使用Iterator和增强for循环循环遍历List<String>的代码，使用上泛型
        List<String> list = new ArrayList<>();  //表明List容器中只可以存放String类型的对象
        list.add("Tom");
        list.add("Amy");
        list.add("Jerry");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        for (String s : list){
            System.out.println(s);
        }
    }

    @Test
    public void test3(){
//  提供一个方法，用于遍历获取HashMap<String,String>中的所有value，并存放在List中返回。考虑上集合中泛型的使用
//        不能直接将value集放到List中，需要一个一个放
        HashMap<String, String> map = new HashMap<>();
        map.put("1","Tom");
        map.put("2","Mary");
        map.put("3","Jack");

        Collection<String> values = map.values();  //values集合为Collection类，不能直接转换为List

        ArrayList<String> list = new ArrayList<>();
        for (String s : values){
            list.add(s);
        }
        System.out.println(list);

    }
    @Test
    public void test4() throws IOException {
        //创建一个与a.txt文件同目录下的另外一个文件b.txt
        File file = new File("D:\\IODemo\\a.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建 " + file.getName() + " 成功");
        }

        File file1 = new File(file.getParent(),"b.txt");
        if (!file1.exists()){
            file1.createNewFile();
            System.out.println("创建 " + file1.getName() + " 成功");
        }

    }

}
