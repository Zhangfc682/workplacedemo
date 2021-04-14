package com.zfc.com.zfc.MapDemo;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-08 08:18
 * @Modified By:
 */

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @ClassName: demo2
 * @Description
 * Properties：是Hashtable的子类，用于处理属性文件，key-value都是字符串类型的。存取数据时，使用 setProperty和 getProperty方法。
 * @Author: Zhangfucai
 * @Date: 2021/4/8 8:18
 * @Version: 1.0
 */
public class demo2 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream("jdbc.properties");
        properties.load(fis);

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("name = " + name + " -- password = " + password);
    }
}
