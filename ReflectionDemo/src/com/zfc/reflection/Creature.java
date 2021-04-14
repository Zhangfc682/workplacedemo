package com.zfc.reflection;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-12 10:43
 * @Modified By:
 */

import java.io.Serializable;

/**
 * @ClassName: Creature
 * @Description TODO
 * @Author: Zhangfucai
 * @Date: 2021/4/12 10:43
 * @Version: 1.0
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
