package com.zfc.GenericDemo.test;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-08 20:03
 * @Modified By:
 */

import java.util.*;

/**
 * @ClassName: DAO
 * @Description
 * Data Access Object(DAO):
 * 定义泛型类DAO<T>,在其中定义一个Map成员变量，Map的键为String类型，值为 T类型。
 *
 * 创建以下方法：
 * public void save(String id, T entity):保存T类型的对象到Map成员变量中。
 * public T get(String id):从map中获取id对应的对象。
 * public void update(String id,T entity):替换map中key为id的内容，改为entity对象。
 * public List<T> list():返回map中存放的所有T对象。
 * public void delete(String id):删除指定id对象。
 *
 * 定义一个User类：
 * private int id，age;String name.
 *
 * 定义一个测试类：
 * 创建DAO类的对象，分别调用其save,get,update,list,delete方法来操作User对象，使用Junit单元测试。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/8 20:03
 * @Version: 1.0
 */
public class DAO<T> {
    private Map<String,T> map;

    public DAO() {
        map = new HashMap<>();
    }

    public void save(String id, T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id,T entity){
        //更新之前，需要判断指定id是否存在
        if (map.containsKey(id)){
            map.put(id,entity);
        }
    }

    public List<T> list(){
//        Set<Map.Entry<String, T>> entrySet = map.entrySet();
//        entrySet.
//        return (List<T>) map.values(); 错误，value集合为无序的可重复的，无法转换为List（有序的可重复的）
        Collection<T> values = map.values();
        //遍历values集合，放入新的List中返回
        List<T> list = new ArrayList<>();
        for (T v : values){
            list.add(v);
        }
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }
}
