package com.zfc.threadPool;/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-01 21:08
 * @Modified By:
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: threadNew
 * @Description 实现callable接口创建线程
 *              1.创建一个实现Callable接口的实现类
 *              2.实现call方法
 *              3.创建callable接口实现类的对象
 *              4.创建FutureTask对象
 *              5.创建Thread对象
 * @Author: Zhangfucai
 * @Date: 2021/4/1 21:08
 * @Version: 1.0
 */
public class threadNew {
    public static void main(String[] args){
        numSum num = new numSum();

        FutureTask futureTask = new FutureTask(num);
        new Thread(futureTask).start();

        try {
            int sum = (int) futureTask.get();
            System.out.println("和为： " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class numSum implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        //线程的具体功能方法，有返回值
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(i);
                sum = sum + i;
            }
        }
        return sum;
    }
}