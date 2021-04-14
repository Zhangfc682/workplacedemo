package com.zfc.GenericDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-08 14:21
 * @Modified By:
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: demo01
 * @Description
 * 泛型练习,自定义泛型类
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/8 14:21
 * @Version: 1.0
 */
public class demo01<T> {
    //自定义泛型类
    String orderName;
    int orderId;
    T orderT;  //使用泛型定义该变量，表示未知的类型

    public demo01(String orderName, int orderId, T orderT) {
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public demo01() {
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "demo01{" +
                "orderName='" + orderName + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //泛型方法，使用与所属类不同的泛型标识符
    //泛型方法可以声明为静态的，因为泛型方法的泛型类型是在调用时指定的，与实例化对象无关。
    public static  <E> List<E> copyFromArrayToList(E[] arr){ // 输入的数组类型是不确定的，用泛型
        ArrayList<E> list = new ArrayList<>();

        for (E e : arr){
            list.add(e);
        }
        return list;
    }

    public static void main(String[] args){
        //如果定义了泛型类，实例化时没有指明泛型的类型，则认为此泛型类型为Object。
        //一般要求定义了泛型时应该在实例化时指明泛型的类型
        demo01<String> de = new demo01<>("Tom",21,"个人");

        de.setOrderT("泛型");
        System.out.println(de.getOrderT());
    }

    @Test
    public void test(){
        /**
         * @author: Zhanfucai
         * @Description:
         * 有限制条件的通配符
         * G<? extends A>: 表示? <= A 类
         * G<? super A>: 表示? >= A 类
         *
         * @date 2021-04-08 19:48:02
         *
         * @return: void
         */
        //通配符：?
        //类A是类B的父类，G<A>和G<B>没有关系，二者共同的父类是：G<?>
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;

        list = list2;
        list = list1;

        //添加：对于List<?>,是不能向其内部添加数据。除了添加null。可以通过get(index)获取元素。读取的数据类型是Object。
//        list.add("sa");
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
