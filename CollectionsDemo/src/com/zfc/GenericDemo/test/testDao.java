package com.zfc.GenericDemo.test;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-08 21:35
 * @Modified By:
 */

import org.junit.Test;

import java.util.List;

/**
 * @ClassName: testDao
 * @Description
 * 定义一个测试类：
 *  创建DAO类的对象，分别调用其save,get,update,list,delete方法来操作User对象，使用Junit单元测试。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/8 21:35
 * @Version: 1.0
 */
public class testDao {
    @Test
    public void test(){
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1001,23,"Tom"));
        userDAO.save("2", new User(1002,26,"Jack"));
        userDAO.save("3", new User(1011,20,"Mary"));

        User user = userDAO.get("1");
        System.out.println(user);

        userDAO.update("3",new User(1011,22,"Mary"));
        System.out.println(userDAO.get("3"));

        List<User> list = userDAO.list();
        System.out.println(list);

        userDAO.delete("1");
        list = userDAO.list();
//        System.out.println(list);
        list.forEach(System.out::println); //Java8新特性
    }
}
