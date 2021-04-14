package com.zfc.IODemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 10:59
 * @Modified By:
 */

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: objectStreamDemo
 * @Description
 * 对象流
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 10:59
 * @Version: 1.0
 */
public class objectStreamDemo {

    //序列化
    @Test
    public void test(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("object.dat")));

            oos.writeObject(new String("你好吗"));
            oos.flush();

            oos.writeObject(new person("张富财",45));
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //反序列化
    @Test
    public void test2(){
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(new File("object.dat")));

            Object o = ois.readObject();
            System.out.println(o.toString());

            Object o1 = ois.readObject();
            System.out.println(o1.getClass());
            System.out.println(o1.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
